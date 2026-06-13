package com.onlinecourse.Controller;

import com.onlinecourse.Model.Cursos;
import com.onlinecourse.Service.ServiceCurso;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ControllerCurso {

    @Inject
    ServiceCurso serviceCurso;

    @POST
    public Response criarCursos(Cursos curso)
    {
        serviceCurso.criaCurso(curso);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listarCursos() {
        List<Cursos> cursos = serviceCurso.listaCursos();
        return Response.status(Response.Status.OK).entity(cursos).build();
    }

    @Path("/{id}")
    @GET
    public Response cursoPorID(@PathParam("id") Long id) {
        return  Response.status(Response.Status.OK)
                .entity(serviceCurso.retornarCursoPorId(id)).build();
    }

    @Path("/instrutor/{id}")
    @GET
    public Response cursosPorInsturtor(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).
                entity(serviceCurso.listarCursosPorIntrutor(id)).build();
    }

    @PUT
    public Response atualizaCurso(Cursos curso) {
        serviceCurso.atualizarCurso(curso);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}/ativar")
    @PATCH
    public Response ativaCurso(@PathParam("id") Long id) {
        serviceCurso.ativarCurso(id);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}/inativa")
    @PATCH
    public Response inativaCurso(@PathParam("id") Long id) {
        serviceCurso.desativarCurso(id);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}")
    @DELETE
    public Response excluirCurso(@PathParam("id") Long id) {
        serviceCurso.deletaCurso(id);
        return Response.status(Response.Status.OK).build();
    }








}
