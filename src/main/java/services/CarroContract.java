package services;

import dto.DtoCarroRequest;
import dto.DtoCarroResponse;
import dto.DtoRequest;
import dto.DtoResponse;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import model.Carro;
import model.Motor;
import model.TipoMotor;

import java.util.List;

public interface CarroContract {
    //POST
     DtoCarroResponse incluir(DtoCarroRequest dto);
    //PUT
     void update( long id, DtoCarroRequest dto);
    //DELETE
     void delete(long id);
    //GET
     List<DtoCarroResponse> exibirTodos();
    //GET adicional
    List<DtoCarroResponse> buscarNome(String nome);



}
