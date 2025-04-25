package services;

import dto.DtoOficina;
import dto.DtoOficinaResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import model.Oficina;
import model.Servico;
import repository.OficinaRepository;
import repository.ServicoRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OficinaServiceImpl implements OficinaContract {

    @Inject
    OficinaRepository oficinaRepository;

    @Inject
    ServicoRepository servicoRepository;

    @Override
    @Transactional
    public DtoOficinaResponse incluir(DtoOficina dto) {
        Oficina oficina = new Oficina();
        oficina.setNome(dto.nome());
        oficina.setEndereco(dto.endereco());

        if(dto.servicosIds() != null && !dto.servicosIds().isEmpty()) {
            List<Servico> servicos = servicoRepository.list("id in ?1", dto.servicosIds());

            // Atualiza ambos os lados do relacionamento
            servicos.forEach(servico -> {
                servico.getOficinas().add(oficina);
            });

            oficina.setServicos(servicos);
        }

        oficinaRepository.persist(oficina);
        return DtoOficinaResponse.valueof(oficina);
    }

    @Override
    @Transactional
    public void update(Long id, DtoOficina dto) {
        Oficina oficina = oficinaRepository.findById(id);
        if(oficina == null) {
            throw new RuntimeException("Oficina não encontrada");
        }

        oficina.setNome(dto.nome());
        oficina.setEndereco(dto.endereco());

        // Atualização dos serviços
        if(dto.servicosIds() != null) {
            List<Servico> novosServicos = servicoRepository.list("id in ?1", dto.servicosIds());

            // Remove das oficinas antigas
            oficina.getServicos().forEach(servico -> {
                servico.getOficinas().remove(oficina);
            });

            // Adiciona aos novos
            novosServicos.forEach(servico -> {
                servico.getOficinas().add(oficina);
            });

            oficina.setServicos(novosServicos);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Oficina oficina = oficinaRepository.findById(id);
        if(oficina != null) {
            // Remove a oficina de todos os serviços associados
            oficina.getServicos().forEach(servico -> {
                servico.getOficinas().remove(oficina);
            });
            oficinaRepository.delete(oficina);
        }
    }

    @Override
    public List<DtoOficinaResponse> exibirTodos() {
        return oficinaRepository.listAll().stream()
                .map(DtoOficinaResponse::valueof)
                .collect(Collectors.toList());
    }

    @Override
    public DtoOficinaResponse buscarPorId(Long id) {
        Oficina oficina = oficinaRepository.findById(id);
        return DtoOficinaResponse.valueof(oficina);
    }
}