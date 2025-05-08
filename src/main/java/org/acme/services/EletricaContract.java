package org.acme.services;

import org.acme.dto.DtoEletricaRequest;
import org.acme.dto.DtoEletricaResponse;

import java.util.List;

public interface EletricaContract {
    //POST
    DtoEletricaResponse incluir(DtoEletricaRequest dto);
    //PUT
    void update( long id, DtoEletricaRequest dto);
    //DELETE
    void delete(long id);
    //GET
    List<DtoEletricaResponse> buscarNome(String nome);

    public DtoEletricaResponse findById(long id);




}
