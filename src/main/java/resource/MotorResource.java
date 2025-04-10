package resource;

import dto.DtoRequest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Motor;
import jakarta.ws.rs.core.Response;
import services.MotorServiceImpl;
import java.util.List;

@Path("/motor")
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
    @Path("/{id}")
    @Transactional
    public Response update(long id, DtoRequest dto) {
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    public Response delete(long id) {
        service.delete(id);
        return Response.noContent().build();
    }

    @GET
    public Response exibirTodos() {
        return Response.ok().entity(service.exibirTodos()).build();
    }


    @GET
    @Path("/BuscaNome")
    public List<Motor> buscarNome(String nome) {
        return service.buscarNome(nome);
    }

    @GET
    @Path("/{id}")
    public Response buscarTipo(@PathParam("id") int id) {
      return service.buscarTipo(id);
    }


}
