package org.acme.services;

import org.acme.dto.DtoRequestMotor;
import org.acme.dto.DtoResponseMotor;
import java.util.List;

public interface MotorContract {
    //POST
     DtoResponseMotor incluir(DtoRequestMotor dto);
    //PUT
     void update( long id, DtoRequestMotor dto);
    //DELETE
     void delete(long id);
    //GET
     List<DtoResponseMotor> exibirTodos();
    //GET adicional
     List<DtoResponseMotor> buscarNome(String nome);
    //GET adicional
    List<DtoResponseMotor> buscarCarro(Long idCarro);

    DtoResponseMotor findById(long id);






}
