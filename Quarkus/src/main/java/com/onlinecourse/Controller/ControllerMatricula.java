package com.onlinecourse.Controller;

import com.onlinecourse.Model.Matricula;
import com.onlinecourse.Service.ServiceMatricula;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/matriculas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControllerMatricula {

    @Inject
    ServiceMatricula serviceMatricula;

    @POST
    public Response inserirMatricula(Matricula matricula) {
        serviceMatricula.cadastrarMatricula(matricula);
        return Response.ok().build();
    }

    @GET
    public Response listarMatriculas() {
        return  Response.ok().entity(serviceMatricula.listaMatriculas()).build();
    }

    @Path("/aluno/{id}")
    @GET
    public Response buscarMatriculasPorAluno(@PathParam("id") Long idAluno) {
        return Response.ok().entity(serviceMatricula.listaMatriculasPorAluno(idAluno)).build();
    }

    @Path("/curso/{id}")
    @GET
    public Response buscarAlunosPorCurso(@PathParam("id") Integer idCurso) {
        return Response.ok().entity(serviceMatricula.listaAlunosporCurso(idCurso)).build();
    }

    @Path("/cancelar/{idMatricula}")
    @PATCH
    public Response cancelarMatricula(@PathParam("idMatricula") Long idMatricula) {
        serviceMatricula.cancelaMatricula(idMatricula);
        return Response.ok().build();
    }

    @Path("/concluir/{idMatricula}")
    @PATCH
    public Response concluirMatricula(@PathParam("idMatricula")Long idMatricula) {
        serviceMatricula.concluiMatricula(idMatricula);
        return Response.ok().build();
    }

}
