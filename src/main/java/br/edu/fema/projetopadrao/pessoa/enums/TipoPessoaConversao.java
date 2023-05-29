package br.edu.fema.projetopadrao.pessoa.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.edu.fema.projetopadrao.utils.conversao.enums.interfaces.ConvertEnum;
import br.edu.fema.projetopadrao.utils.conversao.enums.service.ConvertEnumNonNull;

@Converter(autoApply = true)
public class TipoPessoaConversao implements AttributeConverter<TipoPessoa, Integer> {

    private ConvertEnum<TipoPessoa, Integer> convertEnum = new ConvertEnumNonNull<>();

    @Override
    public Integer convertToDatabaseColumn(TipoPessoa tipoPessoa) {
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(tipoPessoa);
    }

    @Override
    public TipoPessoa convertToEntityAttribute(Integer dbData) {
        return convertEnum.getEnum(TipoPessoa.values(), dbData);
    }

}
