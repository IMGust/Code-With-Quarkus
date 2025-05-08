package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoEletricaRequest(
        @NotBlank(message = "O nome deve ser informado.")
        String marca,
        @NotBlank(message = "O nome deve ser informado.")
        String nome,
        @NotBlank(message = "O nome deve ser informado.")
        String voltagem,
        @NotNull
        int estoque
) {
}
