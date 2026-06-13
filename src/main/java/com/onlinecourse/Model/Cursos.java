package com.onlinecourse.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onlinecourse.Model.Enumerate.NivelCurso;
import com.onlinecourse.Model.Enumerate.Status;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="Cursos")
public class Cursos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCursos;

    private String nomeCurso;

    private String descricaoCurso;

    private Long duracaoAnos;

    @Enumerated(EnumType.STRING)
    private NivelCurso nivelCurso;

    @Enumerated(EnumType.STRING)
    private Status status;

    public String getDescricaoCurso() {
        return descricaoCurso;
    }

    public void setDescricaoCurso(String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Long getDuracaoAnos() {
        return duracaoAnos;
    }

    public void setDuracaoAnos(Long duracaoAnos) {
        this.duracaoAnos = duracaoAnos;
    }

    public NivelCurso getNivelCurso() {
        return nivelCurso;
    }

    public void setNivelCurso(NivelCurso nivelCurso) {
        this.nivelCurso = nivelCurso;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getIdCursos() {
        return idCursos;
    }

    @ManyToOne
    @JoinColumn(name = "idInstrutor") // Nome da coluna no banco
    @JsonBackReference(value = "curso-instrutor")
    private Instrutor fkInstrutor;
    public void setFkInstrutor(Instrutor fkInstrutor) {
        this.fkInstrutor = fkInstrutor;
    }
    public  Instrutor getFkInstrutor() {
        return fkInstrutor;
    }


    @OneToMany(mappedBy = "cursos")
    @JsonManagedReference(value = "curso-matricula")
    private List<Matricula> matriculasCursos;

    public List<Matricula> getMatriculasCursos() {
        return matriculasCursos;
    }


}