package services;

import dto.DtoCarroRequest;
import dto.DtoCarroResponse;
import dto.DtoRequest;
import dto.DtoResponse;
import model.Carro;
import model.Motor;

import java.util.List;

public interface CarroContract {
    //POST
    public DtoCarroResponse incluir(DtoCarroRequest dto);
    //PUT
    public void update( long id, DtoCarroRequest dto);
    //DELETE
    public void delete(long id);
    //GET
    public List<DtoCarroResponse> exibirTodos();
    //GET adicional
    public List<Carro> buscarNome(String nome);


}
