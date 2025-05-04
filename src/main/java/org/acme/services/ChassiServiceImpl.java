package org.acme.services;

import org.acme.dto.DtoChassiRequest;
import org.acme.dto.DtoChassiResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.Chassi;
import org.acme.repository.CarroRepository;
import org.acme.repository.ChassiRepository;
import java.util.List;

@ApplicationScoped
public class ChassiServiceImpl implements ChassiContract {

    @Inject
    ChassiRepository repository;

    @Inject
    CarroRepository carroRepository;

    @Override
    @Transactional
    public DtoChassiResponse incluir(DtoChassiRequest dto) {
        Chassi chassi = new Chassi();
        chassi.setNumero(dto.numero());
        repository.persist(chassi);

        return DtoChassiResponse.valueof(chassi);
    }

    @Override
    @Transactional
    public void update(long id, DtoChassiRequest dto) {
        Chassi chassi = repository.findById(id);
        chassi.setNumero(dto.numero());

    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public DtoChassiResponse findById(long id) {
        return DtoChassiResponse.valueof(repository.findById(id));
    }

    @Override
    public List<DtoChassiResponse> exibirTodos() {
        return repository.findAll().stream()
                .map(DtoChassiResponse::valueof)
                .toList();
    }
    @Override
    public List<DtoChassiResponse> buscarNome(String numero){
        return repository.findByName(numero).stream().map(e -> DtoChassiResponse.valueof(e)).toList();
    }


}
