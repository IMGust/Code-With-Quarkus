package org.acme.services;

import org.acme.dto.DtoMotorRequest;
import org.acme.dto.DtoMotorResponse;
import java.util.List;

public interface MotorContract {
    //POST
     DtoMotorResponse incluir(DtoMotorRequest dto);
    //PUT
     void update( long id, DtoMotorRequest dto);
    //DELETE
     void delete(long id);
    //GET
     List<DtoMotorResponse> exibirTodos();
    //GET adicional
     List<DtoMotorResponse> buscarNome(String nome);
    //GET adicional
    List<DtoMotorResponse> buscarCarro(Long idCarro);

    DtoMotorResponse findById(long id);






}
