package services;

import dto.DtoPecaEletrica;
import dto.DtoEletricaResponse;

import java.util.List;

public interface PecaEletrciaContract {
    //POST
    DtoEletricaResponse incluir(DtoPecaEletrica dto);
    //PUT
    void update( long id, DtoPecaEletrica dto);
    //DELETE
    void delete(long id);
    //GET
    List<DtoEletricaResponse> exibirTodos();




}
