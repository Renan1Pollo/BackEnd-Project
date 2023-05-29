package br.edu.fema.projetopadrao.utils.enums;

import br.edu.fema.projetopadrao.utils.conversao.enums.interfaces.GettersEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * Enum genérico para aplicações que
 * tenham atributos em entidades que fazem
 * referência a uma coluna no banco de dados
 * que possui constantes "S" e "N"
 * 
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 18/05/2022
 * @version 1.0
 *
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Resposta implements GettersEnum<String> {

	SIM("S", "Sim"),
	NAO("N", "Não");
	
	
	private String valor;
	private String descricao;
}
