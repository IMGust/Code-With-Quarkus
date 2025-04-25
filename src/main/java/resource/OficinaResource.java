package resource;

import dto.DtoOficina;
import dto.DtoOficinaResponse;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.OficinaServiceImpl;


@Path("oficina")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OficinaResource {

    @Inject
    OficinaServiceImpl service;

    @POST
    @Transactional
    public Response incluir(DtoOficina dto) {
        return Response.ok().entity(service.incluir(dto)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response update( Long id, DtoOficina dto){
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
}
