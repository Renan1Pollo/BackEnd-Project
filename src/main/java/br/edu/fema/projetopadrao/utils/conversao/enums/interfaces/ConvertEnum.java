package br.edu.fema.projetopadrao.utils.conversao.enums.interfaces;

import javax.persistence.AttributeConverter;

/**
 * 
 * Interface responsável pela abstração de
 * código ao trabalhar com Enums que
 * implementem a interface {@link ValorEnum} <br>
 * 
 * Esta interface pode estar presente na classe
 * de conversão do Enum que será utilizado em uma
 * Entidade, fazendo referência a um campo do banco
 * de dados <br>
 * 
 * Em conjunto com a interface {@link AttributeConverter}
 * que converte um valor do banco para o tipo do Enum e
 * pega o valor do enum que para salvá-lo no banco, 
 * esta interface contribuirá para reduzir códigos boilerplate,
 * ou seja, códigos que se repetem em várias partes da aplicação
 * 
 *
 * @param <E> - Tipo do Enum que deverá implementar a interface
 * {@link ValorEnum}
 * @param <T> - Tipo do valor do Enum que será utilizado
 * para referenciar a respectiva coluna do banco que o Enum
 * representará
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.0
 * 
 */
public interface ConvertEnum<E extends Enum<? extends ValorEnum<T>>, T> {

	/**
	 * Método responsável por pegar o valor
	 * do Enum que irá ser salvo no banco de dados
	 * 
	 * @param tipoEnum - {@code E}
	 * @return {@code T} - Valor do Enum
	 */
	T getRepresentacaoValorEnumParaBancoDeDados(E tipoEnum);
	
	/**
	 * Método responsável por converter o valor
	 * referente ao Enum do banco de dados para o
	 * tipo do Enum
	 * 
	 * @param valoresEnum - {@code E[]}
	 * @param valorEnum - {@code T}
	 * @return {@code E} - Enum
	 */
	E getEnum(E[] valoresEnum, T valorEnum);
}
