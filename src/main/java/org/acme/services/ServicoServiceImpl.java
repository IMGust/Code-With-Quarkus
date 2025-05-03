package org.acme.services;


import org.acme.dto.DtoRequestServico;
import org.acme.dto.DtoServicoResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.Servico;
import org.acme.repository.OficinaRepository;
import org.acme.repository.ServicoRepository;
import java.util.List;

@ApplicationScoped
public class ServicoServiceImpl implements ServicoContract {

    @Inject
    ServicoRepository repository;

    @Inject
    OficinaRepository oficinaRepository;

    @Override
    @Transactional
    public DtoServicoResponse incluir(DtoRequestServico dto) {
        Servico servico = new Servico();
        servico.setNome(dto.nome());

        repository.persist(servico);

        return DtoServicoResponse.valueof(servico);
    }

    @Override
    @Transactional
    public void update(long id, DtoRequestServico dto) {
        Servico servico = repository.findById(id);
        if(servico == null) {
            throw new RuntimeException("Serviço não encontrado");
        }
        servico.setNome(dto.nome());

    }

    @Override
    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DtoServicoResponse> buscarNome(String nome) {
        return repository.findByName(nome).stream()
                .map(e -> DtoServicoResponse.valueof(e)).toList();
    }

    @Override
    public DtoServicoResponse findById(long id) {
        return DtoServicoResponse.valueof(repository.findById(id));
    }




}