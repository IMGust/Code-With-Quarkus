package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Oficina;

@ApplicationScoped
public class OficinaRepository implements PanacheRepository<Oficina> {
}
