package org.acme.services;

import org.acme.dto.UsuarioResponseDto;

public interface UsuarioService {

    // UsuarioResponseDTO create(UsuarioDTO usuario);
    // void update(long id, UsuarioDTO usuario);
    // void delete(long id);
    // UsuarioResponseDTO findById(long id);
    // UsuarioResponseDTO findBySigla(String sigla);
    // List<UsuarioResponseDTO> findAll();
    UsuarioResponseDto findByUsernameAndSenha(String username, String senha);
    UsuarioResponseDto findByUsername(String username);


}