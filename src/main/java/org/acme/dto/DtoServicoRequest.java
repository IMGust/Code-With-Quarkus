package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record DtoServicoRequest(
        @NotBlank(message = "O nome deve ser informado.")
        String nome

){

}
