package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.PecaEletrica;

import java.util.List;

@ApplicationScoped
public class EletricaRepository implements PanacheRepository<PecaEletrica> {


    public List<PecaEletrica> findByName(String nome){
        return find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%").list();

    }

}
