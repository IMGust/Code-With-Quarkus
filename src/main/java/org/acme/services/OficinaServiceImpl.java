package org.acme.services;


import org.acme.dto.DtoOficinaRequest;
import org.acme.dto.DtoOficinaNome;
import org.acme.dto.DtoOficinaResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.Oficina;
import org.acme.model.Servico;
import org.acme.repository.OficinaRepository;
import org.acme.repository.ServicoRepository;

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
    public DtoOficinaResponse incluir(DtoOficinaRequest dto) {
        Oficina oficina = new Oficina();
        oficina.setNome(dto.nome());
        oficina.setEndereco(dto.endereco());

        if(dto.servicosIds() != null && !dto.servicosIds().isEmpty()) {
            List<Servico> servicos = servicoRepository.list("id in ?1", dto.servicosIds());
            oficina.setServicos(servicos);
        }

        oficinaRepository.persist(oficina);
        return DtoOficinaResponse.valueof(oficina);
    }

    @Override
    @Transactional
    public void update(Long id, DtoOficinaRequest dto) {
        Oficina oficina = oficinaRepository.findById(id);
        if (oficina == null) {
            throw new RuntimeException("Oficina não encontrada");
        }

        oficina.setNome(dto.nome());
        oficina.setEndereco(dto.endereco());

        if (dto.servicosIds() != null) {
            List<Servico> servicos = servicoRepository.list("id in ?1", dto.servicosIds());
            oficina.setServicos(servicos);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Oficina oficina = oficinaRepository.findById(id);
        if (oficina != null) {
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

    @Override
    public DtoOficinaResponse findById(long id) {
        return DtoOficinaResponse.valueof(oficinaRepository.findById(id));
    }





    @Override
    public List<DtoOficinaResponse> buscarNome(String nome) {
        return oficinaRepository.find("nome", nome).list().stream()
                .map(DtoOficinaResponse::valueof)
                .toList();
    }
    @Override
    public List<DtoOficinaNome> buscarPorServico(String nomeServico) {
        return oficinaRepository.buscarPorServico(nomeServico)
                .stream()
                .map(oficina -> new DtoOficinaNome(oficina.getNome()))
                .toList();
    }

}