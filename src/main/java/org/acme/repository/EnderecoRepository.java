package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Endereco;

import java.util.List;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {

    public List<Endereco> BuscarPorUser(Long idUser){
        return find("usuario.id = ?1", idUser).list(); // ou SELECT * FROM endereco e WHERE e.id_usuario = ?
        // usuario.id siginifica que buscar dentro no atributo usuario buscar por o atributo id
    }

}