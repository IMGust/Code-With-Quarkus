package org.acme.services;

import org.acme.dto.DtoCarroRequest;
import org.acme.dto.DtoCarroResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.Carro;
import org.acme.model.Chassi;
import org.acme.model.TipoMotor;
import org.acme.repository.CarroRepository;
import org.acme.repository.ChassiRepository;
import java.util.List;

@ApplicationScoped
public class CarroServiceImpl implements CarroContract {

    @Inject
    CarroRepository carroRepository;

    @Inject
    ChassiRepository chassiRepository;

    @Override
    @Transactional
    public DtoCarroResponse incluir(DtoCarroRequest dto) {
        Carro carro = new Carro();
        carro.setNome(dto.nome());
        carro.setClassificacao(dto.classificacao());

        carro.setTipoMotor(TipoMotor.valueof(dto.idTipoMotor()));

        // Buscar chassi por ID
        Chassi chassi = chassiRepository.findById(dto.chassiId());

        carro.setChassi(chassi); // Associar o chassi ao carro

        carroRepository.persist(carro);
        return DtoCarroResponse.valueof(carro);
    }

    @Override
    @Transactional
    public void update(long id, DtoCarroRequest dto) {
        Carro carro = carroRepository.findById(id);
        carro.setNome(dto.nome());
        carro.setClassificacao(dto.classificacao());
        carro.setTipoMotor(TipoMotor.valueof(dto.idTipoMotor()));

        // Buscar chassi por ID
        Chassi chassi = chassiRepository.findById(dto.chassiId());
        carro.setChassi(chassi);
    }

    @Override
    @Transactional
    public void delete(long id) {
        carroRepository.deleteById(id);
    }

    @Override
    public List<DtoCarroResponse> exibirTodos() {
        return carroRepository.findAll().stream()
                .map(DtoCarroResponse::valueof)
                .toList();
    }

    @Override
    public List<DtoCarroResponse> buscarNome(String nome) {
        return carroRepository.find("nome", nome).stream()
                .map(DtoCarroResponse::valueof)
                .toList();
    }
    @Override
    public DtoCarroResponse findById(long id) {
        return DtoCarroResponse.valueof(carroRepository.findById(id));
    }

}
