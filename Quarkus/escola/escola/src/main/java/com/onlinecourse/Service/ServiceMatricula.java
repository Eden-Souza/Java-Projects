package com.onlinecourse.Service;

import com.onlinecourse.Model.Aluno;
import com.onlinecourse.Model.Cursos;
import com.onlinecourse.Model.Enumerate.Status;
import com.onlinecourse.Model.Matricula;
import com.onlinecourse.Repository.RepoAluno;
import com.onlinecourse.Repository.RepoCursos;
import com.onlinecourse.Repository.RepoMatricula;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServiceMatricula {

    @Inject
    RepoMatricula repoMatricula;
    @Inject
    RepoCursos  repoCursos;
    @Inject
    RepoAluno  repoAluno;

    @Transactional
    public void cadastrarMatricula(Matricula matricula){

        Cursos cursoBuscado = repoCursos.findById(matricula.getCursos().getIdCursos().longValue());
        boolean isCursoBuscadoAtivo = cursoBuscado.getStatus().equals(Status.ATIVO);

        Aluno alunoBuscado = repoAluno.findById(matricula.getAluno().getIdAluno());
        boolean isAlunoBuscadoAtivo = alunoBuscado.getStatus().equals(Status.ATIVO);

        boolean isAlunoCadastrado = repoMatricula.listAll().stream().anyMatch(matriculasBd -> matriculasBd.getAluno().getIdAluno().equals(matricula.getAluno().getIdAluno())
                && matriculasBd.getCursos().getIdCursos().equals(matricula.getCursos().getIdCursos()));
                //map transforma cada item em um valor, neste caso boolean mas aqui ele faz uma lista de booelan


        if (isCursoBuscadoAtivo && isAlunoBuscadoAtivo && !isAlunoCadastrado) {
            repoMatricula.persist(matricula);
        }
        else {
            throw new RuntimeException("Aluno ou Curso estão Inativos");
        }
    }

    public List<Matricula> listaMatriculas() {
        return repoMatricula.listAll();
    }

    public List<String> listaMatriculasPorAluno(Long idAluno) {
        return repoMatricula.listAll().stream().filter(matricula -> matricula.getAluno().getIdAluno().equals(idAluno)).
                map(matricula -> matricula.getCursos().getNomeCurso()).collect(Collectors.toList());
    } // Ele faz uma matricula todos os cursos relacionados, collect coleta os dados e organiza de acordo com o argumento
        // estou usando o map para transformar as matriculas em cursos

    public List<String> listaAlunosporCurso(Integer idCurso) {
        return repoMatricula.listAll().stream().filter(matricula -> matricula.getCursos().getIdCursos().equals(idCurso)).
                map(matricula -> matricula.getAluno().getNome()).collect(Collectors.toList());

    }

    @Transactional
    public void cancelaMatricula(Long id){
        try {
            Matricula matriculaCancelada = repoMatricula.findById(id);
            matriculaCancelada.setStatus(Status.BLOQUEADO);
        } catch (RuntimeException e) {
            throw new RuntimeException(" Matricula inexistente");
        }
    }

    @Transactional
    public void concluiMatricula(Long id){
        try {
            Matricula matriculaAtivada =repoMatricula.findById(id);
            matriculaAtivada.setStatus(Status.ATIVO);
        } catch (RuntimeException e) {
            throw new RuntimeException(" Matricula inexistente");
        }
    }


}
