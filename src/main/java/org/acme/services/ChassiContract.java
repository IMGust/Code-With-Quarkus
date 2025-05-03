package org.acme.services;

import org.acme.dto.DtoChassiRequest;
import org.acme.dto.DtoChassiResponse;
import org.acme.dto.DtoResponseMotor;

import java.util.List;

public interface ChassiContract {
    //POST
    DtoChassiResponse incluir(DtoChassiRequest dto);
    //PUT
    void update( long id, DtoChassiRequest dto);
    //DELETE
    void delete(long id);
    //GET
    List<DtoChassiResponse> exibirTodos();

    DtoChassiResponse findById(long id);

    List<DtoChassiResponse> buscarNome(String nome);



}
