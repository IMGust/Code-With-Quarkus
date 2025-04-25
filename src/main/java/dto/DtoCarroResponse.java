package dto;

import model.Carro;
import model.TipoMotor;

public record DtoCarroResponse(Long id, String nome, TipoMotor motor,  DtoChassiResponse chassi ) {

    public static DtoCarroResponse valueof(Carro carro){
        if(carro == null) return null;
        return new DtoCarroResponse(carro.getId(), carro.getNome(), carro.getTipoMotor(),
               DtoChassiResponse.valueof(carro.getChassi()));

    }
}
