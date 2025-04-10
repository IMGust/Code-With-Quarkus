package model;

import jakarta.persistence.*;

@Entity
@Table(name = "motor")
public class Motor extends DefaultEntity {

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private int preco;

    private TipoMotor tipomotor;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getPreco(){
        return preco;
    }

    public void setPreco(int preco){
        this.preco = preco;
    }

    public TipoMotor getTipomotor() {
        return tipomotor;
    }

    public void setTipomotor(TipoMotor tipomotor) {
        this.tipomotor = tipomotor;
    }
}
