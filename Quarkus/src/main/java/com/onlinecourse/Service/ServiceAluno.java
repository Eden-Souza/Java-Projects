package com.onlinecourse.Service;

import com.onlinecourse.Model.Aluno;
import com.onlinecourse.Model.Enumerate.Status;
import com.onlinecourse.Repository.RepoAluno;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
@ApplicationScoped
public class ServiceAluno {

    @Inject
    RepoAluno repoAluno;

    @Transactional
    public void cadastraAluno(Aluno aluno) {
        boolean emailCadastrado = repoAluno.findAll()
                .stream().anyMatch(alunoDB -> alunoDB.getEmail().equalsIgnoreCase(aluno.getEmail()));
        if (emailCadastrado) {
            throw new RuntimeException("Email já foi cadastrado");
        }
        else {
            repoAluno.persist(aluno);
        }

    }

    public List<Aluno> listarAlunos() {
        return repoAluno.listAll();
    }

    public Aluno buscaAluno(Long id) {
        return repoAluno.findById(id);
    }

    @Transactional
    public void atualizaAluno(Aluno aluno) {
        Aluno alunoAlterado = repoAluno.findById(aluno.getIdAluno());
        alunoAlterado.setNome(aluno.getNome());
        alunoAlterado.setEmail(aluno.getEmail());
        alunoAlterado.setStatus(aluno.getStatus());
    }

    @Transactional
    public void inativaAluno(Long id) {
        repoAluno.findById(id).setStatus(Status.INATIVO);
    }



}
