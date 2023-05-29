package br.edu.fema.projetopadrao.exception.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

/**
 * 
 * Classe responsável por armazenar todos os erros de validação
 * que foram gerados
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.0
 * 
 */
public class ValidationError extends ExcecaoPadronizada {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private List<FieldMessage> errors = new ArrayList<>();
	
	
	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}
	

	/**
	 * Método responsável por adicionar os erros de validação
	 * na lista
	 * @param fieldName - Nome do campo
	 * @param message - Mensagem do erro
	 */
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
}
