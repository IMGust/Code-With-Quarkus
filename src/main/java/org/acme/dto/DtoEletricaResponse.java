package org.acme.dto;
import org.acme.model.PecaEletrica;

public record DtoEletricaResponse(Long id, String marca, String nome, String voltagem, int estoque) {


    public static DtoEletricaResponse valueof(PecaEletrica eletrica){
        if(eletrica == null) return null;
            return new DtoEletricaResponse(eletrica.getId(), eletrica.getMarca(), eletrica.getNome(), eletrica.getVoltagem(), eletrica.getEstoque());

    }


}
