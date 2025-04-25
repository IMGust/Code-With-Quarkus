package services;
import dto.DtoPecaEletrica;
import dto.DtoEletricaResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.PecaEletrica;
import repository.MarcaRepository;

import java.util.List;

@ApplicationScoped
public class EletricaServiceImpl implements PecaEletrciaContract {

    @Inject
    MarcaRepository repository;


    @Override
    @Transactional
    public DtoEletricaResponse incluir(DtoPecaEletrica dto){
        PecaEletrica eletrica = new PecaEletrica();
        eletrica.setMarca(dto.marca());
        eletrica.setVoltagem(dto.voltagem());
        eletrica.setNome(dto.nome());
        //pesistência
        repository.persist(eletrica);
        return DtoEletricaResponse.valueof(eletrica);
    }


    @Override
    @Transactional
    public void update(long id, DtoPecaEletrica dto){
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
    public List<DtoEletricaResponse> exibirTodos(){
        return repository.findAll().stream().map(a -> DtoEletricaResponse.valueof(a)).toList();
    }

}
