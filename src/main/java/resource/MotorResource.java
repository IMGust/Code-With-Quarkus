package resource;

import dto.DtoRequest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.MotorServiceImpl;

@Path("motor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MotorResource {


    @Inject
    MotorServiceImpl service;

    @POST
    @Transactional
    public Response incluir(DtoRequest dto) {
        return Response.ok().entity(service.incluir(dto)).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(long id, DtoRequest dto) {
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        service.delete(id);
        return Response.noContent().build();
    }

    @GET
    public Response exibirTodos() {
        return Response.ok().entity(service.exibirTodos()).build();
    }


    @GET
    @Path("/nome/{nome}")
    public Response buscarNome(String nome){
       return  Response.ok().entity(service.buscarNome()).build();
    }

    @GET
    @Path("/carro/{id}")
    public Response buscarCarro(Long id){
        return Response.status(Response.Status.OK).entity(service.buscarCarro(id)).build();
    }

}
