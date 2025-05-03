package org.acme.services;

import org.acme.dto.DtoPecaEletrica;
import org.acme.dto.DtoEletricaResponse;

import java.util.List;

public interface EletricaContract {
    //POST
    DtoEletricaResponse incluir(DtoPecaEletrica dto);
    //PUT
    void update( long id, DtoPecaEletrica dto);
    //DELETE
    void delete(long id);
    //GET
    List<DtoEletricaResponse> buscarNome(String nome);

    public DtoEletricaResponse findById(long id);




}
