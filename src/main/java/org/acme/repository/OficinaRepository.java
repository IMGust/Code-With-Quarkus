package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Oficina;
import java.util.List;

@ApplicationScoped
public class OficinaRepository implements PanacheRepository<Oficina> {

    public List<Oficina> buscarOficina(String nome){
        return find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%").list();
    }

    public List<Oficina> buscarPorServico(String nomeServico) {
        return getEntityManager().createQuery("""
            SELECT DISTINCT o
            FROM Oficina o
            JOIN o.servicos s
            WHERE LOWER(s.nome) LIKE :nomeServico
        """, Oficina.class)
                .setParameter("nomeServico", "%" + nomeServico.toLowerCase() + "%")
                .getResultList();
    }
}

