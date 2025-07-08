package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.UsuarioResponseDto;
import org.acme.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository repository;

    @Override
    public UsuarioResponseDto findByUsernameAndSenha(String username, String senha) {
        return UsuarioResponseDto.valueOf(
                repository.findByUsernameAndSenha(username, senha)
        );

    }

    @Override
    public UsuarioResponseDto findByUsername(String username) {
        return UsuarioResponseDto.valueOf(
                repository.findByUsername(username)
        );
    }

}
