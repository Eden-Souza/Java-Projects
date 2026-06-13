package com.onlinecourse.Repository;

import com.onlinecourse.Model.Aluno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepoAluno implements PanacheRepository<Aluno> {


}
