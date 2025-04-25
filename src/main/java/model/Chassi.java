package model;

import jakarta.persistence.*;

@Entity
public class Chassi extends DefaultEntity{
    @Column
    private String numero;

    @OneToOne(mappedBy = "chassi")
    private Carro carro;

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}

