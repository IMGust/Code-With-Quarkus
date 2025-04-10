package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Carro;

@ApplicationScoped
public class CarroRepository implements PanacheRepository<Carro> {



}
