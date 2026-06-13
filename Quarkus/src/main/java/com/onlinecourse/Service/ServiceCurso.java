package com.onlinecourse.Service;


import com.onlinecourse.Model.Cursos;
import com.onlinecourse.Model.Enumerate.Status;
import com.onlinecourse.Model.Instrutor;
import com.onlinecourse.Repository.RepoCursos;
import com.onlinecourse.Repository.RepoInstrutor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ServiceCurso {

    @Inject
    RepoCursos repoCursos;
    @Inject
    RepoInstrutor repoInstrutor;

    @Transactional
    public void criaCurso (Cursos cursoCriado) {

            List<Instrutor> instrutorAtivo =
                    repoInstrutor.findAll().stream()
                            .filter(instrutorStatus -> instrutorStatus.getStatus().equals(Status.ATIVO)).toList();
                            //map tranforma cada elemento em outro valor
                            // anymatch retorna para cada elemento true ou false
            // O GETFIRST SO FUNCIONA EM ARRAYLIST EU ESTOU USANDO UM LIST
            cursoCriado.setFkInstrutor(instrutorAtivo.getFirst()); // Posso alterar o valor antes de persistir ele no banco
            repoCursos.persist(cursoCriado);
            System.out.println("Instrutores ativos encontrados: " + instrutorAtivo);

        }



    public List<Cursos> listaCursos() {
        return repoCursos.listAll();
    }

    public Cursos retornarCursoPorId(Long id) {
        return repoCursos.findById(id);
    }

    public List<Cursos> listarCursosPorIntrutor(Long idInstrutor) {
        return repoCursos.listAll().stream()
                .filter(curso -> curso.getFkInstrutor().getIdInstrutor()== idInstrutor).toList();
    }

    @Transactional
    public void atualizarCurso(Cursos solicitacaoAlteracao) {
        Cursos cursoAlterado = repoCursos.findById(solicitacaoAlteracao.getIdCursos().longValue());
        cursoAlterado.setNomeCurso(solicitacaoAlteracao.getNomeCurso());
        cursoAlterado.setDescricaoCurso(solicitacaoAlteracao.getDescricaoCurso());
        cursoAlterado.setDuracaoAnos(solicitacaoAlteracao.getDuracaoAnos());
        cursoAlterado.setNivelCurso(solicitacaoAlteracao.getNivelCurso());
    }

    @Transactional
    public void ativarCurso(Long idCurso) {
        Cursos  curso = repoCursos.findById(idCurso);
        boolean instrutorAtivo = repoInstrutor.findById(curso.getFkInstrutor().getIdInstrutor()).getStatus().equals(Status.ATIVO);

    if (instrutorAtivo) {
        curso.setStatus(Status.ATIVO);
    } else {
        throw new RuntimeException(" Curso não possui instrutores ativos");
    }
    }

    @Transactional
    public void desativarCurso(Long idCurso) {
        Cursos  curso = repoCursos.findById(idCurso);
        curso.setStatus(Status.INATIVO);
    }

    @Transactional
    public void deletaCurso(Long idCurso) {
        Cursos curso = repoCursos.findById(idCurso);
        long tamanhoLista = curso.getMatriculasCursos()
                .size();
        if (tamanhoLista > 0) {
            throw new RuntimeException("Curso com Matriculas Cadastradas");
        } else  {
            repoCursos.delete(curso);
        }
    }





}
