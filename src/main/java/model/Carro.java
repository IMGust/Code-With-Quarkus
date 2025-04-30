package model;

import jakarta.persistence.*;

@Entity
@Table(name = "carro")
public class Carro extends DefaultEntity{

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chassi_id", referencedColumnName = "id")
    private Chassi chassi;

    private TipoMotor tipoMotor;

    public void setTipoMotor(TipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Chassi getChassi() {
        return chassi;
    }

    public void setChassi(Chassi chassi) {
        this.chassi = chassi;
    }
}