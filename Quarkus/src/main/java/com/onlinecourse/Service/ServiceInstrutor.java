package com.onlinecourse.Service;

import com.onlinecourse.Model.Enumerate.Status;
import com.onlinecourse.Model.Instrutor;
import com.onlinecourse.Repository.RepoInstrutor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ServiceInstrutor {

    @Inject
    RepoInstrutor repoInstrutor;

    // Cadastrar instrutor que o email não exista

    @Transactional
    public void cadastrarInstrutor(Instrutor instrutor) {
        boolean existe = repoInstrutor.findAll()
                .stream().anyMatch(instrutorCadastrado ->instrutorCadastrado.getEmail().equals(instrutor.getEmail()));
        // o antes do lambda sempre é a lista que eu fiz, instrutorBanco  é o "retorno do meu for"
        if (!existe) {
            repoInstrutor.persist(instrutor);
        } else
        { throw new RuntimeException("Instrutor ja existente"); }

    }

    public List<Instrutor> retornarInstrutor() {
        return repoInstrutor.listAll();
    }

    public Instrutor retornarInstrutorPorId(Long id) {

        try {
        return repoInstrutor.findById(id); } catch (Exception e) {
            throw new RuntimeException("Instrutor nao encontrado");
        }
    }

    @Transactional
    public void atualizaDadosPorId(Long id, Instrutor instrutorModificado) {
            Instrutor instrutor = repoInstrutor.findById(id);
            if (instrutor==null) {
                throw new RuntimeException("Instrutor nao encontrado");}
            else {
                if (!instrutor.getNome().equalsIgnoreCase(instrutorModificado.getNome()) && instrutor.getNome() != null) {
                    instrutor.setNome(instrutorModificado.getNome());
                }
                if (!instrutor.getEspecialidade().equalsIgnoreCase(instrutorModificado.getEspecialidade()) && instrutor.getEspecialidade() != null) {
                    instrutor.setEspecialidade(instrutorModificado.getEspecialidade());
                }
                if (!instrutor.getStatus().equals(instrutorModificado.getStatus()) && instrutor.getEspecialidade() != null) {
                    instrutor.setStatus(instrutorModificado.getStatus());
                }
            }

    }



    @Transactional
    public void inativaInstrutorPorId(Long id) {
        try {
            Instrutor instrutor = repoInstrutor.findById(id);
            instrutor.setStatus(Status.INATIVO);
        }
        catch (Exception e) {
            throw new RuntimeException("Instrutor nao encontrado");
        }

    }
    @Transactional
    public void deleteInstrutorPorId(Long id) {
        try {
        boolean cursoAtivo = repoInstrutor.findById(id)
                .getCursosPorInstrutor().stream()
                .anyMatch(curso -> curso.getStatus() == Status.ATIVO);

        if (cursoAtivo) {
            throw new RuntimeException("Este instrutor tem Cursos Ativo");
        } else {
            repoInstrutor.deleteById(id);
        }

        } catch (RuntimeException e) {
            throw new RuntimeException("Instrutor nao encontrado");
        }
    }
}
