package services;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import dto.DtoRequest;
import dto.DtoResponse;
import jakarta.transaction.Transactional;
import model.Carro;
import model.Motor;
import repository.CarroRepository;
import repository.MotorRepository;

import java.util.List;
@ApplicationScoped
public class MotorServiceImpl implements MotorContract {
    @Inject
    MotorRepository repository;
    @Inject
    CarroRepository carroRepository;

    @Override
    @Transactional
     public DtoResponse incluir(DtoRequest dto){
        Motor motor = new Motor();
        motor.setNome(dto.nome());
        motor.setPreco(dto.preco());

        //Busca ID
        Carro carro = carroRepository.findById(dto.idCarro());
        motor.setCarro(carro);

        //pesistência

        repository.persist(motor);
        return DtoResponse.valueof(motor);
    }

    @Override
    @Transactional
    public void update(long id, DtoRequest dto){
        Motor motor = repository.findById(id);
        motor.setNome(dto.nome());
        motor.setPreco(dto.preco());

        //Busca id
        Carro carro = carroRepository.findById(dto.idCarro());
        motor.setCarro(carro);

    }
    @Override
    @Transactional
    public void delete(long id){
        repository.deleteById(id);

    }
    @Override
    public List<DtoResponse> exibirTodos(){
        return repository.findAll().stream().map(e -> DtoResponse.valueof(e)).toList();
    }

    @Override
    public List<DtoResponse> buscarNome(){
    return repository.findAll().stream().map(e -> DtoResponse.valueof(e)).toList();
    }

    @Override
    public List<DtoResponse> buscarCarro( Long idCarro){
        return repository.findByCar(idCarro).stream().map(e -> DtoResponse.valueof(e)).toList();
    }


}
