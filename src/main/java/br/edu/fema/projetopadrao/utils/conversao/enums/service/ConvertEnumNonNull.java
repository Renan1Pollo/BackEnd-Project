package br.edu.fema.projetopadrao.utils.conversao.enums.service;

import java.util.Objects;

import br.edu.fema.projetopadrao.utils.conversao.enums.interfaces.ConvertEnum;
import br.edu.fema.projetopadrao.utils.conversao.enums.interfaces.ValorEnum;

/**
 *
 * Classe responsável por manipular um Enum
 * que pode ter o seu valor que fará referência
 * ao banco de dados como nulo
 *
 * @param <E> - Tipo do Enum que deverá implementar
 * a interface {@link ValorEnum}
 * @param <T> - Tipo do valor do Enum
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.1 - 26/07/2022
 * 
 */
public final class ConvertEnumNonNull<E extends Enum<E> & ValorEnum<T>, T> implements ConvertEnum<E, T> {

	@Override
	public T getRepresentacaoValorEnumParaBancoDeDados(E tipoEnum) {
		return tipoEnum.getValor();
	}

	@Override
	public E getEnum(E[] valoresEnum, T valorEnum) {
		if (Objects.isNull(valorEnum))
			throw new NullPointerException("O 'valorEnum' não pode "
				+ "ser convertido para o Enum '" + valoresEnum.getClass().getSimpleName().split("\\[\\]")[0]
				+ "' pois ele está nulo!");
		
		for (E valorEnumAtual : valoresEnum) 
			if (valorEnumAtual.getValor().equals(valorEnum))
				return valorEnumAtual;
		
		throw new IllegalArgumentException("O valor '" + valorEnum 
			+ "' para o Enum '" + valoresEnum.getClass().getSimpleName().split("\\[\\]")[0]
			+ "' é inválido!");
	}
}
