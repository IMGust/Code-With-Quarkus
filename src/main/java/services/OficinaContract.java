package services;

import dto.DtoOficina;
import dto.DtoOficinaNome;
import dto.DtoOficinaResponse;

import java.util.List;

public interface OficinaContract {

    //POST
    DtoOficinaResponse incluir(DtoOficina dto);
    //PUT
    void update( Long id, DtoOficina dto);
    //DELETE
    void delete(Long id);
    //GET
    List<DtoOficinaResponse> exibirTodos();
    //GET
    DtoOficinaResponse buscarPorId(Long id);

    List<DtoOficinaResponse> buscarNome(String nome);

    List<DtoOficinaNome> buscarPorServico(String nomeServico);


}
