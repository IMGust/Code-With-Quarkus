package org.acme.model;

import jakarta.persistence.*;

@Entity
public class Chassi extends DefaultEntity{
    @Column
    private String numero;

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero;}

}



