package services;

import dto.DtoCarroRequest;
import dto.DtoCarroResponse;
import dto.DtoResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Carro;
import repository.CarroRepository;
import repository.MotorRepository;

import java.util.List;

@ApplicationScoped
public class CarroServiceImpl implements CarroContract{
    @Inject
    CarroRepository carroRepository;

    @Inject
    MotorRepository motorRepository;

    @Override
    @Transactional
    public DtoCarroResponse incluir(DtoCarroRequest dto){
        Carro carro = new Carro();
        carro.setNome(dto.nome());
        //pesistência
        carroRepository.persist(carro);
        return DtoCarroResponse.valueof(carro);
    }

    @Override
    public void update(long id, DtoCarroRequest dto){
        Carro carro = carroRepository.findById(id);
        carro.setNome(dto.nome());

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
    public List<Carro> buscarNome(String nome){
        return carroRepository.find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%").list();

    }






}
