package org.acme.services;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.DtoRequestMotor;
import org.acme.dto.DtoResponseMotor;
import jakarta.transaction.Transactional;
import org.acme.model.Carro;
import org.acme.model.Motor;
import org.acme.repository.CarroRepository;
import org.acme.repository.MotorRepository;

import java.util.List;
@ApplicationScoped
public class MotorServiceImpl implements MotorContract {
    @Inject
    MotorRepository repository;
    @Inject
    CarroRepository carroRepository;

    @Override
    @Transactional
     public DtoResponseMotor incluir(DtoRequestMotor dto){
        Motor motor = new Motor();
        motor.setNome(dto.nome());
        motor.setPreco(dto.preco());

        //Busca ID
        Carro carro = carroRepository.findById(dto.idCarro());
        motor.setCarro(carro);

        //pesistência

        repository.persist(motor);
        return DtoResponseMotor.valueof(motor);
    }

    @Override
    @Transactional
    public void update(long id, DtoRequestMotor dto){
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
    public List<DtoResponseMotor> exibirTodos(){
        return repository.findAll().stream().map(e -> DtoResponseMotor.valueof(e)).toList();
    }

    @Override
    public List<DtoResponseMotor> buscarNome(String nome){
    return repository.findByName(nome).stream().map(e -> DtoResponseMotor.valueof(e)).toList();
    }

    @Override
    public DtoResponseMotor findById(long id) {
        return DtoResponseMotor.valueof(repository.findById(id));
    }



    @Override
    public List<DtoResponseMotor> buscarCarro(Long idCarro){
        return repository.findByCar(idCarro).stream().map(e -> DtoResponseMotor.valueof(e)).toList();
    }


}
