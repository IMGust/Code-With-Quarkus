package services;


import dto.DtoServico;
import dto.DtoServicoResponse;

import java.util.List;

public interface ServicoContract {
    //POST
    DtoServicoResponse incluir(DtoServico dto);
    //PUT
    void update( long id, DtoServico dto);
    //DELETE
    void delete(long id);
    //GET
    List<DtoServicoResponse> exibirTodos();
}
