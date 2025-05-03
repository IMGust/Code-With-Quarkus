package org.acme.services;


import org.acme.dto.DtoRequestServico;
import org.acme.dto.DtoServicoResponse;

import java.util.List;

public interface ServicoContract {
    //POST
    DtoServicoResponse incluir(DtoRequestServico dto);
    //PUT
    void update( long id, DtoRequestServico dto);
    //DELETE
    void delete(long id);
    //GET
    List<DtoServicoResponse> buscarNome(String nome);

    DtoServicoResponse findById(long id);

    }

