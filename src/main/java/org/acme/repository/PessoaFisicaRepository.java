package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.PessoaFisica;

import java.util.List;

@ApplicationScoped
public class PessoaFisicaRepository  implements PanacheRepository<PessoaFisica> {

    public List<PessoaFisica> findByNome(String nome) {
        return find("nome LIKE ?1 ", "%" + nome + "%").list();
    }

    public PessoaFisica findByCpf(String cpf) {
        return find("cpf = ?1 ", cpf).firstResult();
    }



}