package br.edu.fema.projetopadrao.pessoa.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.edu.fema.projetopadrao.utils.conversao.enums.interfaces.ConvertEnum;
import br.edu.fema.projetopadrao.utils.conversao.enums.service.ConvertEnumNonNull;

@Converter(autoApply = true)
public class EstadoCivilConversao implements AttributeConverter<EstadoCivil, String> {

    private ConvertEnum<EstadoCivil, String> convertEnum = new ConvertEnumNonNull<>();

    @Override
    public String convertToDatabaseColumn(EstadoCivil estadoCivil) {
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(estadoCivil);
    }

    @Override
    public EstadoCivil convertToEntityAttribute(String dbData) {
        return convertEnum.getEnum(EstadoCivil.values(), dbData);
    }

}
