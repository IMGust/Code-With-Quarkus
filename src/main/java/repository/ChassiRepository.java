package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Chassi;


@ApplicationScoped
public class ChassiRepository implements PanacheRepository<Chassi> {


}
