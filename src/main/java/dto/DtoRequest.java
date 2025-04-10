package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DtoRequest(
        @NotBlank(message = "O nome deve ser informado")
        String nome,

        @NotNull(message = "Valor deve ser informado")
        int preco,

        Integer idmotor

) {
}
