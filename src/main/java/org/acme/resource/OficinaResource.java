package org.acme.resource;

import org.acme.dto.DtoOficinaRequest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.services.OficinaServiceImpl;

@Path("oficina")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OficinaResource {

    @Inject
    OficinaServiceImpl service;

    @POST
    @Transactional
    public Response incluir(DtoOficinaRequest dto) {
       return Response.status(Response.Status.CREATED).entity(service.incluir(dto)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response update( Long id, DtoOficinaRequest dto){
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(Long id) {
        service.delete(id);
        return Response.noContent().build();
    }

    @GET
    public Response exibirTodos(){
        return Response.status(Response.Status.OK).entity(service.exibirTodos()).
                build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id){
        return Response.status(Response.Status.OK).entity(service.buscarPorId(id)).build();
        }

    @GET
    @Path("/nome/{nome}")
    public Response buscarNome(String nome){
        return Response.status(Response.Status.OK).entity(service.buscarNome(nome)).build();
    }

    @GET
    @Path("/nome/servico")
    public Response buscarOficinaPorNomeDoServico(@QueryParam("nome") String nomeServico) {
        if (nomeServico == null || nomeServico.isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parâmetro 'nome' é obrigatório.")
                    .build();
        }

        return Response.ok(service.buscarPorServico(nomeServico)).build();
    }

}
