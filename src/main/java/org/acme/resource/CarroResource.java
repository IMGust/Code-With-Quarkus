package org.acme.resource;

import org.acme.dto.DtoCarroRequest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.services.CarroServiceImpl;


@Path("carro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarroResource {

@Inject
CarroServiceImpl service;

    @POST
    @Transactional
    public Response incluir(DtoCarroRequest dto) {
        return Response.status(Response.Status.CREATED).entity(service.incluir(dto)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response update( long id, DtoCarroRequest dto){
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
    public Response exibirTodos(){
        return Response.status(Response.Status.OK).entity(service.exibirTodos()).build();
    }


    @GET
    @Path("/nome/{nome}")
    public Response buscarNome(String nome){
        return Response.status(Response.Status.OK).entity(service.buscarNome(nome)).build();
    }

    @GET
    @Path("buscar/{id}")
    public Response findById(long id){
        return Response.status(Response.Status.OK).entity(service.findById(id)).build();

    }
}
