package com.onlinecourse.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onlinecourse.Model.Enumerate.Status;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Instrutor")
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idInstrutor;

    private String nome;
    private String email;

    private String especialidade;

    @Enumerated(EnumType.STRING)
    private Status status;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String Especialidade) {
        this.especialidade = Especialidade;
    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getIdInstrutor() {
        return idInstrutor;
    }

    // mappedby diz que isso é uma pk, o cascade q tudo q acontece com um acontece com o outro
    //orphanremoval se apagar o registro da chave primaria da pk tbm

    @OneToMany(mappedBy = "fkInstrutor") // mappedby seria que a outra tabela que manda onde o pk aparece
    @JsonManagedReference(value = "curso-instrutor")
    private List<Cursos> cursosPorInstrutor; // mostrando q o instrutor tem uma lista de cursos

    public List<Cursos> getCursosPorInstrutor() {
        return cursosPorInstrutor;
    }
}
