package model;


import jakarta.persistence.Entity;


@Entity
public class PecaEletrica extends Peca {

    private String marca;

    private String voltagem;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }
}
