package org.acme.services;

import org.acme.dto.DtoCarroRequest;
import org.acme.dto.DtoCarroResponse;

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

    DtoCarroResponse findById(long id);



}
