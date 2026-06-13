package com.onlinecourse.Repository;

import com.onlinecourse.Model.Matricula;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepoMatricula implements PanacheRepository<Matricula> {
}
