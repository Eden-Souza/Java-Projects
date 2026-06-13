package com.onlinecourse.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onlinecourse.Model.Enumerate.Status;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "aluno")
    @JsonManagedReference(value = "aluno-matricula")
    private List<Matricula> matriculasAluno;

    public List<Matricula> getMatriculasAluno() {
        return matriculasAluno;
    }

    public Long getIdMatricula() {
        return idAluno;
    }

}
