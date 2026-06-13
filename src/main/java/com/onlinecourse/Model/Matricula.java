package com.onlinecourse.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onlinecourse.Model.Enumerate.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatricula;

    private LocalDate dataMatricula = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Status status;

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @ManyToOne
    @JsonBackReference(value = "curso-matricula")
    @JoinColumn(name = "idCursos") // Nome no banco
    private Cursos cursos;

    public Cursos getCursos() {
        return cursos;
    }


    @ManyToOne
    @JsonBackReference(value = "aluno-matricula") // Em classes com mais de um backreference tem que dar nome se não fica doidao
    @JoinColumn(name = "idAluno")
    private Aluno aluno;

    public Aluno getAluno() {

        return aluno;
    }


}
