package services;

import dto.DtoChassi;
import dto.DtoChassiResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Chassi;
import repository.CarroRepository;
import repository.ChassiRepository;
import java.util.List;

@ApplicationScoped
public class ChassiServiceImpl implements ChassiContract {

    @Inject
    ChassiRepository repository;

    @Inject
    CarroRepository carroRepository;

    @Override
    @Transactional
    public DtoChassiResponse incluir(DtoChassi dto) {
        Chassi chassi = new Chassi();
        chassi.setNumero(dto.numero());
        repository.persist(chassi);

        return DtoChassiResponse.valueof(chassi);
    }

    @Override
    @Transactional
    public void update(long id, DtoChassi dto) {
        Chassi chassi = repository.findById(id);
        chassi.setNumero(dto.numero());

    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DtoChassiResponse> exibirTodos() {
        return repository.findAll().stream()
                .map(DtoChassiResponse::valueof)
                .toList();
    }
}
