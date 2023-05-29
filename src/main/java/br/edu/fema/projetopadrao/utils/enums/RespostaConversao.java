package br.edu.fema.projetopadrao.utils.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.edu.fema.projetopadrao.utils.conversao.enums.interfaces.ConvertEnum;
import br.edu.fema.projetopadrao.utils.conversao.enums.service.ConvertEnumMaybeNull;

/**
 * 
 * Classe responsável por pegar o valor do enum {@link Resposta}
 * e enviá-lo ao banco e para fazer conversão de um valor
 * para a respectiva constante do Enum <br>
 * 
 * Esta classe trabalha com a conversão de um valor
 * para o Enum que pode ser nulo, por isso caso
 * seja necessário restringí-lo a fim de não aceitar este
 * Enum como nulo, será preciso anotar o atributo
 * em sua respectiva entidade
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.0
 *
 */
@Converter(autoApply = true)
public class RespostaConversao implements AttributeConverter<Resposta, String> {
	
	private ConvertEnum<Resposta, String> convertEnum = new ConvertEnumMaybeNull<>();

	@Override
	public String convertToDatabaseColumn(Resposta resposta) {
		return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(resposta);
	}

	@Override
	public Resposta convertToEntityAttribute(String dbData) {
		return convertEnum.getEnum(Resposta.values(), dbData);
	}
}
