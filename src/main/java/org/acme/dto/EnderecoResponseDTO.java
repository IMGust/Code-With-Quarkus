package org.acme.dto;

import org.acme.model.Endereco;

public record EnderecoResponseDTO(
        Long id,
        String quadra,
        Integer lote,
        UsuarioResponseDto User) {

    public static EnderecoResponseDTO valueOf(Endereco endereco){

        if (endereco == null){
            return null;
        }

        return new EnderecoResponseDTO(
                endereco.getId(),
                endereco.getQuadra(),
                endereco.getLote(),
                UsuarioResponseDto.valueOf(endereco.getUsuario())

        );

    }

}

