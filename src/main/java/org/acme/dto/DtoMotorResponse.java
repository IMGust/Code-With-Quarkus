package org.acme.dto;

import org.acme.model.Motor;

public record DtoMotorResponse(Long id, String nome, double preco, DtoCarroResponse carro) {

    public static DtoMotorResponse valueof(Motor motor){
        if(motor == null)
            return null;
        return new DtoMotorResponse(motor.getId(), motor.getNome(), motor.getPreco(), DtoCarroResponse.valueof(motor.getCarro()));

    }
}
