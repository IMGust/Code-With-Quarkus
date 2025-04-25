package resource;

import dto.DtoChassi;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import services.ChassiServiceImpl;

@Path("chassi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChassiResource {

    @Inject
    ChassiServiceImpl service;


    @POST
    @Transactional
    public Response incluir(DtoChassi dto) {
        return Response.ok().entity(service.incluir(dto)).build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response update( long id, DtoChassi dto){
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
    public Response exibirTodos() {
        return Response.status(Response.Status.OK).
                entity(service.exibirTodos()).build();
    }
}
