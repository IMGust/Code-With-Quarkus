package org.acme.dto;

import org.acme.model.Perfil;
import org.acme.model.Usuario;

public record UsuarioResponseDto(
        Long id,
        String nome,
        String username,
        Perfil perfil) {

    public static UsuarioResponseDto valueOf(Usuario usuario) {
        if (usuario == null)
            return null;
        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getPessoaFisica().getNome(),
                usuario.getUsername(),
                usuario.getPerfil());
    }

}
