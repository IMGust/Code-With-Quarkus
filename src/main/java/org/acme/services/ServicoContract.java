package org.acme.services;


import org.acme.dto.DtoServicoRequest;
import org.acme.dto.DtoServicoResponse;

import java.util.List;

public interface ServicoContract {
    //POST
    DtoServicoResponse incluir(DtoServicoRequest dto);
    //PUT
    void update( long id, DtoServicoRequest dto);
    //DELETE
    void delete(long id);
    //GET
    List<DtoServicoResponse> buscarNome(String nome);

    DtoServicoResponse findById(long id);

    }

