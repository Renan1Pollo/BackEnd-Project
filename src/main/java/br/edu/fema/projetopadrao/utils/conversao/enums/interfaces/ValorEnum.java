package br.edu.fema.projetopadrao.utils.conversao.enums.interfaces;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 *
 * Interface responsável por dar mais flexibilidade
 * ao trabalhar com Enums que fazem referência a uma
 * coluna do banco de dados <br>
 * 
 * Esta interface também passou a servir para definir
 * qual o atributo do Enum que será utilizado para
 * converter um atributo de formulário para o respectivo
 * tipo do Enum. Disponível a partir da versão 1.1
 * 
 * @param <T> - Tipo do valor do Enum que fará
 * referência ao tipo de dado da coluna do banco
 * de dados
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.1 - 26/07/2022
 * 
 */
public interface ValorEnum<T> {

	/**
	 * Método responsável por retornar
	 * o valor do Enum
	 * 
	 * @return {@code T} - Valor do Enum
	 */
	@JsonValue
	T getValor();
}
