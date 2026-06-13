package com.onlinecourse.Controller;

import com.onlinecourse.Model.Instrutor;
import com.onlinecourse.Service.ServiceInstrutor;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/instrutores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ControllerInstrutor {

    @Inject
    ServiceInstrutor serviceInstrutor;


    @POST
    public Response cadastraInstrutores(Instrutor instrutor) {
        serviceInstrutor.cadastrarInstrutor(instrutor);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response listaInstrutores() {
        List<Instrutor> listaInstrutor = serviceInstrutor.retornarInstrutor();

        return Response.status(Response.Status.OK).entity(listaInstrutor).build();
    }

    @Path("/{id}")
    @GET
    public Response buscaInstrutor(@PathParam("id") Long id) {
        Instrutor instrutor =serviceInstrutor.retornarInstrutorPorId(id);
        return Response.status(Response.Status.OK).entity(instrutor).build();
    }

    @Path("/{id}")
    @PATCH
    public Response atualizaInstrutor(@PathParam("id") Long id, Instrutor instrutor) {
        serviceInstrutor.atualizaDadosPorId(id,instrutor);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{id}/inativar")
    @PATCH
    public Response inativaInstrutor(@PathParam("id") Long id ) {
        serviceInstrutor.inativaInstrutorPorId(id);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletaInstrutor(@PathParam("id") Long id) {
        serviceInstrutor.deleteInstrutorPorId(id);
        return Response.status(Response.Status.ACCEPTED).build();
    }









}
