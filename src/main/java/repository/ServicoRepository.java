package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Servico;

@ApplicationScoped
public class ServicoRepository  implements PanacheRepository<Servico> {
}
