package services;

import dto.DtoCarroRequest;
import dto.DtoCarroResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Carro;
import model.Chassi;
import model.TipoMotor;
import repository.CarroRepository;
import repository.ChassiRepository;

import java.util.List;

@ApplicationScoped
public class CarroServiceImpl implements CarroContract{

    @Inject
    CarroRepository carroRepository;

    @Inject
    ChassiRepository chassiRepository;

    @Override
    @Transactional
    public DtoCarroResponse incluir(DtoCarroRequest dto){
        Carro carro = new Carro();
        carro.setNome(dto.nome());
        carro.setTipoMotor(TipoMotor.valueof(dto.idMotor()));
            //busca ID
        Chassi chassi = chassiRepository.findById(dto.idchassi());
        chassi.setCarro(carro);

        //pesistência
        carroRepository.persist(carro);
        return DtoCarroResponse.valueof(carro);
    }


    @Override
    public void update(long id, DtoCarroRequest dto){
        Carro carro = carroRepository.findById(id);
        carro.setNome(dto.nome());
        carro.setTipoMotor(TipoMotor.valueof(dto.idMotor()));
        //busca id Chassi
        Chassi chassi = chassiRepository.findById(dto.idchassi());
        chassi.setCarro(carro);
    }
    @Override
    public void delete(long id){
        carroRepository.deleteById(id);

    }



    @Override
    public List<DtoCarroResponse> exibirTodos(){
        return carroRepository.findAll().stream().map(e -> DtoCarroResponse.valueof(e)).toList();
    }

    @Override
    public List<DtoCarroResponse> buscarNome(String nome){
        return carroRepository.findAll().stream().map(e -> DtoCarroResponse.valueof(e)).toList();

    }


}
