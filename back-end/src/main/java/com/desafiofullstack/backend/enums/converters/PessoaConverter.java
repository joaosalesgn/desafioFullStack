package com.desafiofullstack.backend.enums.converters;

import com.desafiofullstack.backend.enums.Pessoa;

import java.util.stream.Stream;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PessoaConverter implements AttributeConverter<Pessoa, String> {
    
    @Override
    public String convertToDatabaseColumn(Pessoa pessoa) {
        if (pessoa == null) {
            return null;
        }
        return pessoa.getValue();
    }

    @Override
    public Pessoa convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Pessoa.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
