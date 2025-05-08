package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DtoOficinaRequest(
        @NotBlank(message = "O nome deve ser informado.")
        String nome,
        @NotBlank(message = "O nome deve ser informado.")
        String endereco,
        @NotNull
        List<Long> servicosIds
) {
}
