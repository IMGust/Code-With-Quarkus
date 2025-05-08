package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
public record DtoCarroRequest(
        @NotBlank(message = "O nome deve ser informado.")
        String nome,

        @NotBlank(message = "O nome deve ser informado.")
        String classificacao ,

        @NotBlank(message = "O nome deve ser informado.")
        Integer idTipoMotor,

        @NotBlank(message = "O nome deve ser informado.")
        Long chassiId
) {
}
