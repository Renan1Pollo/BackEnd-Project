package br.edu.fema.projetopadrao.exception.model;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * Classe para erros de validação que será utilizada para
 * armazenar o nome do campo que gerou uma exceção e a 
 * mensagem do erro
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.0
 * 
 */
@Getter
@AllArgsConstructor
public class FieldMessage implements Serializable {
	
	@Getter(value = AccessLevel.NONE)
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;
}
