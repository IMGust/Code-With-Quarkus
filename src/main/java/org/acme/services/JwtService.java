package org.acme.services;

public interface JwtService {

    String generateJwt(String username, String perfil);

}