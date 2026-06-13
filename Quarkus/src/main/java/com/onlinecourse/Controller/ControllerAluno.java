package com.onlinecourse.Controller;

import com.onlinecourse.Model.Aluno;
import com.onlinecourse.Service.ServiceAluno;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ControllerAluno {

    @Inject
    ServiceAluno serviceAluno;

    @POST
    public Response criaAluno(Aluno aluno) {
        serviceAluno.cadastraAluno(aluno);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listaAlunos() {
        return Response.ok().entity(serviceAluno.listarAlunos()).build();
    }

    @Path("/{id}")
    @GET
    public Response buscaAluno(@PathParam("id") Long id) {
        return Response.ok().entity(serviceAluno.buscaAluno(id)).build();
    }

    @PUT
    public Response atualizaAluno(Aluno aluno) {
        serviceAluno.atualizaAluno(aluno);
        return Response.ok().build();
    }

    @Path("/{id}/inativar")
    @PATCH
    public Response inativaAluno(@PathParam("id") Long id) {
        serviceAluno.inativaAluno(id);
        return Response.ok().build();
    }





}
