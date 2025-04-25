package model;

import jakarta.persistence.*;

@Entity
@Table(name = "motor")
public class Motor extends DefaultEntity {

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private double preco;

    @ManyToOne
    @JoinColumn(name = "id_carro")
    private Carro carro;

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

