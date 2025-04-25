package dto;

import model.Motor;

public record DtoResponse(Long id, String nome, DtoCarroResponse carro) {

    public static DtoResponse valueof(Motor motor){
        if(motor == null)
            return null;
        return new DtoResponse(motor.getId(), motor.getNome(), DtoCarroResponse.valueof(motor.getCarro()));

    }
}
