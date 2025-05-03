package org.acme.dto;

import org.acme.model.Carro;
import org.acme.model.TipoMotor;

public record DtoCarroResponse(Long id, String nome , String classificacao , TipoMotor motor,  DtoChassiResponse chassi ) {

    public static DtoCarroResponse valueof(Carro carro){
        if(carro == null) return null;
        return new DtoCarroResponse(carro.getId(), carro.getNome(), carro.getClassificacao(), carro.getTipoMotor(),
               DtoChassiResponse.valueof(carro.getChassi()));

    }
}
