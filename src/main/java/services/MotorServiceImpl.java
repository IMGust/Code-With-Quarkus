package services;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import dto.DtoRequest;
import dto.DtoResponse;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import model.Motor;
import model.TipoMotor;
import repository.MotorRepository;

import java.util.List;
@ApplicationScoped
public class MotorServiceImpl implements MotorContract {
    @Inject
    MotorRepository repository;

    @Override
    @Transactional
     public DtoResponse incluir(DtoRequest dto){
        Motor motor = new Motor();
        motor.setNome(dto.nome());
        motor.setPreco(dto.preco());
        motor.setTipomotor(TipoMotor.valueof(dto.idmotor()));

        repository.persist(motor);
        return DtoResponse.valueof(motor);
    }

    @Override
    public void update(long id, DtoRequest dto){
        Motor motor = repository.findById(id);
        motor.setNome(dto.nome());
        motor.setPreco(dto.preco());
        motor.setTipomotor(TipoMotor.valueof(dto.idmotor()));
    }
    @Override
    public void delete(long id){
        repository.deleteById(id);

    }
    @Override
    public List<DtoResponse> exibirTodos(){
        return repository.findAll().stream().map(e -> DtoResponse.valueof(e)).toList();
    }
    @Override
    public List<Motor> buscarNome(String nome){
        return repository.find("LOWER(nome) LIKE LOWER(?1)", "%" + nome + "%").list();

    }

    @Override
    public Response buscarTipo(@PathParam("id") int id) {
        try {
            TipoMotor motor = TipoMotor.valueof(id);
            return Response.ok(motor).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Status com id " + id + " não encontrado")
                    .build();
        }
    }
}
