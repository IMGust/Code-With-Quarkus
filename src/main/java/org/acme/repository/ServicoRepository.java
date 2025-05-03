package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Servico;

import java.util.List;

@ApplicationScoped
public class ServicoRepository  implements PanacheRepository<Servico> {

    public List<Servico> findByName(String nome){
        return find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%").list();

    }


}
