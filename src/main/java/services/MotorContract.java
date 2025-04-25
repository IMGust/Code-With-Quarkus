package services;

import dto.DtoRequest;
import dto.DtoResponse;
import java.util.List;

public interface MotorContract {
    //POST
     DtoResponse incluir(DtoRequest dto);
    //PUT
     void update( long id, DtoRequest dto);
    //DELETE
     void delete(long id);
    //GET
     List<DtoResponse> exibirTodos();
    //GET adicional
     List<DtoResponse> buscarNome();
    //GET adicional
    List<DtoResponse> buscarCarro(Long idCarro);






}
