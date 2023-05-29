package br.edu.fema.projetopadrao.utils.conversao.enums.model;

import br.edu.fema.projetopadrao.utils.conversao.enums.interfaces.GettersEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 
 * Classe responsável por permitir enviar os
 * dados de um Enum que implemente a interface
 * {@link GettersEnum} para o front
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
@ToString
public class InformacaoEnum {

	private Object valor;
	private String descricao;
}
