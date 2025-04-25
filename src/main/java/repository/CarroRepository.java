package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Carro;

import java.util.List;

@ApplicationScoped
public class CarroRepository implements PanacheRepository<Carro> {

    public List<Carro> buscarNome(String nome){
        return find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%").list();

    }

}
