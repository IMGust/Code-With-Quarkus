package model.convertjpa;

import jakarta.persistence.AttributeConverter;

import jakarta.persistence.Converter;
import model.TipoMotor;

@Converter(autoApply = true)
public class MotorConvert implements AttributeConverter<TipoMotor, Integer> {

@Override
    public Integer convertToDatabaseColumn(TipoMotor tipomotor){
            return tipomotor == null? null: tipomotor.getID();
}

@Override
    public TipoMotor convertToEntityAttribute(Integer id){ return TipoMotor.valueof(id);}



}
