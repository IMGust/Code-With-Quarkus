package services;

import dto.DtoServico;
import dto.DtoServicoResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Servico;
import repository.OficinaRepository;
import repository.ServicoRepository;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServicoServiceImpl implements ServicoContract {

    @Inject
    ServicoRepository repository;

    @Inject
    OficinaRepository oficinaRepository;

    @Override
    @Transactional
    public DtoServicoResponse incluir(DtoServico dto) {
        Servico servico = new Servico();
        servico.setNome(dto.nome());

        repository.persist(servico);

        return DtoServicoResponse.valueof(servico);
    }

    @Override
    @Transactional
    public void update(long id, DtoServico dto) {
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
    public List<DtoServicoResponse> exibirTodos() {
        return repository.listAll().stream()
                .map(DtoServicoResponse::valueof)
                .collect(Collectors.toList());
    }
}