package services;

import dto.DtoChassi;
import dto.DtoChassiResponse;

import java.util.List;

public interface ChassiContract {
    //POST
    DtoChassiResponse incluir(DtoChassi dto);
    //PUT
    void update( long id, DtoChassi dto);
    //DELETE
    void delete(long id);
    //GET
    List<DtoChassiResponse> exibirTodos();
}
