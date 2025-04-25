package services;

import dto.DtoOficina;
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
    public DtoOficinaResponse buscarPorId(Long id);
}
