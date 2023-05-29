package br.edu.fema.projetopadrao.pessoa.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.edu.fema.projetopadrao.utils.conversao.enums.interfaces.ConvertEnum;
import br.edu.fema.projetopadrao.utils.conversao.enums.service.ConvertEnumNonNull;

@Converter(autoApply = true)
public class SexoConversao implements AttributeConverter<Sexo, String> {
    
    private ConvertEnum<Sexo, String> convertEnum = new ConvertEnumNonNull<>();

    @Override
    public String convertToDatabaseColumn(Sexo sexo) {
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(sexo);
    }

    @Override
    public Sexo convertToEntityAttribute(String dbData) {
        return convertEnum.getEnum(Sexo.values(), dbData);
    }
}
