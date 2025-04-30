package dto;

import model.Chassi;

public record DtoCarroRequest(String nome, Integer idMotor, Long chassiId) {
}
