package org.acme.dto;

import org.acme.model.Chassi;

public record DtoChassiResponse(long id, String numero) {

    public static DtoChassiResponse valueof(Chassi chassi){
        if(chassi == null) return null;
        return new DtoChassiResponse(chassi.getId(), chassi.getNumero());
    }

}
