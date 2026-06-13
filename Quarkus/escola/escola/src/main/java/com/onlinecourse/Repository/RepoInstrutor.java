package com.onlinecourse.Repository;

import com.onlinecourse.Model.Instrutor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepoInstrutor implements PanacheRepository<Instrutor> {
}
