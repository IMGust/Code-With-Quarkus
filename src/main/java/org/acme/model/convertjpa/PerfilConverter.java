package org.acme.model.convertjpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.acme.model.Perfil;

@Converter(autoApply = true)
public class PerfilConverter implements AttributeConverter<Perfil, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Perfil perfil) {
        return perfil == null ? null : perfil.getID();

    }

    @Override
    public Perfil convertToEntityAttribute(Integer id) {
        return Perfil.valueof(id);
    }

}