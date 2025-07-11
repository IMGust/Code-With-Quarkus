package org.acme.services;


import org.acme.dto.DtoOficinaRequest;
import org.acme.dto.DtoOficinaNome;
import org.acme.dto.DtoOficinaResponse;

import java.util.List;

public interface OficinaContract {

    //POST
    DtoOficinaResponse incluir(DtoOficinaRequest dto);
    //PUT
    void update( Long id, DtoOficinaRequest dto);
    //DELETE
    void delete(Long id);
    //GET
    List<DtoOficinaResponse> exibirTodos();
    //GET
    DtoOficinaResponse buscarPorId(Long id);

    List<DtoOficinaResponse> buscarNome(String nome);

    List<DtoOficinaNome> buscarPorServico(String nomeServico);

    DtoOficinaResponse findById(long id);


}
