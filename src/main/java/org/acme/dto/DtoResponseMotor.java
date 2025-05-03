package org.acme.dto;

import org.acme.model.Motor;

public record DtoResponseMotor(Long id, String nome, double preco, DtoCarroResponse carro) {

    public static DtoResponseMotor valueof(Motor motor){
        if(motor == null)
            return null;
        return new DtoResponseMotor(motor.getId(), motor.getNome(), motor.getPreco(), DtoCarroResponse.valueof(motor.getCarro()));

    }
}
