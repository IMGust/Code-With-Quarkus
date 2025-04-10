package dto;

import model.Carro;

public record DtoCarroResponse( Long id, String nome, DtoResponse motor) {

    public static DtoCarroResponse valueof(Carro carro){
        if(carro == null) return null;
        return new DtoCarroResponse(carro.getId(), carro.getNome(), DtoResponse.valueof(carro.getMotor()));

    }
}
