package org.acme.resource;

import org.acme.dto.DtoServicoRequest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.services.ServicoServiceImpl;

@Path("servico")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicoResource {

    @Inject
    ServicoServiceImpl service;


    @POST
    @Transactional
    public Response incluir(DtoServicoRequest dto) {
        return Response.status(Response.Status.CREATED).entity(service.incluir(dto)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response update( long id, DtoServicoRequest dto){
        service.update(id, dto);
        return Response.noContent().build();
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(long id) {
        service.delete(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/nome/{nome}")
    public Response buscarNome(String nome){
        return Response.status(Response.Status.OK).entity(service.buscarNome(nome)).build();
    }



}
