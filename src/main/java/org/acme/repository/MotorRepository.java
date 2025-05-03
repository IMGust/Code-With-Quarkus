package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Motor;

import java.util.List;

@ApplicationScoped
public class MotorRepository implements PanacheRepository<Motor> {

    public List<Motor> findByName(String nome){
        return find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%").list();

    }

    public List<Motor> findByCar(Long idCarro) {
        return find("SELECT m FROM Motor m WHERE m.carro.id = ?1", idCarro).list();
    }
}





