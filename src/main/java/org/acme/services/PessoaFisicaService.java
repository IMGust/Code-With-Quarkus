package org.acme.services;

import org.acme.dto.DtoPessoaFisica;
import org.acme.dto.PessoaFisicaResponseDto;

import java.util.List;

public interface PessoaFisicaService {
    PessoaFisicaResponseDto create(DtoPessoaFisica pessoafisica);
    void update(long id, DtoPessoaFisica pessoafisica);
    void delete(long id);
    PessoaFisicaResponseDto findById(long id);
    List<PessoaFisicaResponseDto> findByNome(String nome);
    PessoaFisicaResponseDto findByCpf(String cpf);
    List<PessoaFisicaResponseDto> findAll();
}