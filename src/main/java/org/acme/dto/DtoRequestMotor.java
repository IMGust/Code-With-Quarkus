package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoRequestMotor(
        @NotBlank(message = "O nome deve ser informado")
        String nome,

        @NotNull(message = "Valor deve ser informado")
        double preco,

        Long idCarro

) {
}
