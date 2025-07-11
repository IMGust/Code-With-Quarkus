package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record DtoChassiRequest(
        @NotBlank(message = "O nome deve ser informado.")
        String numero
) {
}
