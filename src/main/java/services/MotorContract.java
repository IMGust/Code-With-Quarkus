package services;

import dto.DtoRequest;
import dto.DtoResponse;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import model.Motor;

import java.util.List;

public interface MotorContract {
    //POST
    public DtoResponse incluir(DtoRequest dto);
    //PUT
    public void update( long id, DtoRequest dto);
    //DELETE
    public void delete(long id);
    //GET
    public List<DtoResponse> exibirTodos();
    //GET adicional
    public List<Motor> buscarNome(String nome);
    //GET
    public Response buscarTipo(@PathParam("id") int id);



}
