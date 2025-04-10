package resource;

import dto.DtoCarroRequest;
import dto.DtoCarroResponse;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Carro;
import services.CarroServiceImpl;
import java.util.List;

@Path("/carro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarroResource {

@Inject
CarroServiceImpl service;

    @POST
    @Transactional
    public DtoCarroResponse incluir(DtoCarroRequest dto) {
        return service.incluir(dto);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void update( long id, DtoCarroRequest dto){
        service.update(id, dto);
    }

    @DELETE
    @Transactional
    public void delete(long id){  service.delete(id);}

    @GET
    public List<DtoCarroResponse> exibirTodos(){
        return service.exibirTodos();
    }


    @GET
    @Path("/BuscaNome")
    public List<Carro> buscarNome(String nome){ return service.buscarNome(nome);}









}
