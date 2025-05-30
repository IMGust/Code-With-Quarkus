package org.acme.dto;

import org.acme.model.PessoaFisica;

public record PessoaFisicaResponseDto(
        Long id,
        String nome,
        String cpf
) {
    public static PessoaFisicaResponseDto valueOf(PessoaFisica pessoaFisica) {
        if (pessoaFisica == null)
            return null;
        return new PessoaFisicaResponseDto(pessoaFisica.getId(),
                pessoaFisica.getNome(),
                pessoaFisica.getCpf());
    }


}