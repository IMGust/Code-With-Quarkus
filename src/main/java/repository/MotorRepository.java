package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Motor;

import java.util.List;

@ApplicationScoped
public class MotorRepository implements PanacheRepository<Motor> {



}
