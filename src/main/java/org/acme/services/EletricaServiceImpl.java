package org.acme.services;
import org.acme.dto.DtoEletricaRequest;
import org.acme.dto.DtoEletricaResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.PecaEletrica;
import org.acme.repository.EletricaRepository;

import java.util.List;

@ApplicationScoped
public class EletricaServiceImpl implements EletricaContract {

    @Inject
    EletricaRepository repository;


    @Override
    @Transactional
    public DtoEletricaResponse incluir(DtoEletricaRequest dto){
        PecaEletrica eletrica = new PecaEletrica();
        eletrica.setMarca(dto.marca());
        eletrica.setVoltagem(dto.voltagem());
        eletrica.setNome(dto.nome());
        eletrica.setEstoque(dto.estoque());
        //pesistência
        repository.persist(eletrica);
        return DtoEletricaResponse.valueof(eletrica);
    }


    @Override
    @Transactional
    public void update(long id, DtoEletricaRequest dto){
        PecaEletrica eletrica = repository.findById( id);
        eletrica.setNome(dto.nome());
        eletrica.setEstoque(dto.estoque());
        eletrica.setVoltagem(dto.voltagem());
        eletrica.setMarca(dto.marca());
    }
    @Override
    public void delete(long id){
        repository.deleteById(id);

    }

    @Override
    public DtoEletricaResponse findById(long id) {
        return DtoEletricaResponse.valueof(repository.findById(id));
    }

    @Override
    public List<DtoEletricaResponse> buscarNome(String nome){
        return repository.findByName(nome).stream().map(a -> DtoEletricaResponse.valueof(a)).toList();
    }

}
