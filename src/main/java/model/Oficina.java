package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Oficina extends DefaultEntity {

    private String nome;

    private String endereco;

    @ManyToMany
    @JoinTable(
            name = "oficina_servico",
            joinColumns = @JoinColumn(name = "oficina_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    public List<Servico> servicos = new ArrayList<>();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
