package br.edu.fema.projetopadrao.exception.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * 
 * Classe responsável por estruturar as informações quando
 * uma exceção for lançada <br>
 * 
 * <b>Atributos:</b><br>
 * <ul>
 * <li>timestamp - Instante em que a exceção foi lançada</li>
 * <li>status - Código HTTP da exceção</li>
 * <li>error - Mensagem genérica do tipo da exceção</li>
 * <li>message - Mensagem específica do motivo que gerou a exceção</li>
 * <li>path - Path da requisição que originou a exceção</li>
 * </ul>
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
@Builder
public class ExcecaoPadronizada implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
}
