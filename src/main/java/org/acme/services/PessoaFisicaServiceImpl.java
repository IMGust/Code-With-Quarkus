package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.dto.DtoPessoaFisica;
import org.acme.dto.PessoaFisicaResponseDto;
import org.acme.model.PessoaFisica;
import org.acme.repository.PessoaFisicaRepository;
import java.util.List;

@ApplicationScoped
public class PessoaFisicaServiceImpl implements PessoaFisicaService{
    @Inject
    PessoaFisicaRepository pessoafisicaRepository;

    @Override
    @Transactional
    public PessoaFisicaResponseDto create(DtoPessoaFisica pessoafisica) {
        PessoaFisica novoPessoaFisica = new PessoaFisica();
        novoPessoaFisica.setNome(pessoafisica.nome());
        novoPessoaFisica.setCpf(pessoafisica.cpf());

        // realizando inclusao
        pessoafisicaRepository.persist(novoPessoaFisica);

        return PessoaFisicaResponseDto.valueOf(novoPessoaFisica);
    }

    @Override
    @Transactional
    public void update(long id, DtoPessoaFisica pessoafisica) {
        PessoaFisica edicaoPessoaFisica = pessoafisicaRepository.findById(id);

        edicaoPessoaFisica.setNome(pessoafisica.nome());
        edicaoPessoaFisica.setCpf(pessoafisica.cpf());
    }

    @Override
    @Transactional
    public void delete(long id) {
        pessoafisicaRepository.deleteById(id);
    }

    @Override
    public PessoaFisicaResponseDto findById(long id) {
        return PessoaFisicaResponseDto.valueOf(pessoafisicaRepository.findById(id));
    }

    @Override
    public PessoaFisicaResponseDto findByCpf(String cpf) {
        return PessoaFisicaResponseDto.valueOf(pessoafisicaRepository.findByCpf(cpf));
    }

    @Override
    public List<PessoaFisicaResponseDto> findByNome(String nome) {

        return pessoafisicaRepository.findByNome(nome).stream().map(pf -> PessoaFisicaResponseDto.valueOf(pf)).toList();
    }

    @Override
    public List<PessoaFisicaResponseDto> findAll() {
        return pessoafisicaRepository.findAll().stream().map(e -> PessoaFisicaResponseDto.valueOf(e)).toList();
    }
}
