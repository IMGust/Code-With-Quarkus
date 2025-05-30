package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Perfil {

    ADM("Adm", 1),
    USER("Users", 2);

    private final String NOME;
    private final int ID;

    Perfil(String nome, int id){
        this.NOME = nome;
        this.ID = id;
    }

    public String getNOME() {
        return NOME;
    }

    public int getID() {
        return ID;
    }


    public static Perfil valueof(Integer id) {
        if (id == null) return null;

        for (Perfil m : Perfil.values()) {
            if (m.getID() == id) {
                return m;
            }
        }

        return null;
    }
}
