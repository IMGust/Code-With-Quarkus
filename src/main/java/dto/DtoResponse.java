package dto;

import model.Motor;
import model.TipoMotor;

public record DtoResponse(long id, String nome, TipoMotor tipomotor) {

    public static DtoResponse valueof(Motor motor){
        if(motor == null)
            return null;
        return new DtoResponse(motor.getId(), motor.getNome(), motor.getTipomotor());

    }
}
