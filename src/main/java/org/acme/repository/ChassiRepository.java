package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Chassi;
import java.util.List;


@ApplicationScoped
public class ChassiRepository implements PanacheRepository<Chassi> {
    public List<Chassi> findByName(String numero){
        return find("LOWER(numero) LIKE LOWER(?1)", "%" + numero + "%").list();

    }

}
