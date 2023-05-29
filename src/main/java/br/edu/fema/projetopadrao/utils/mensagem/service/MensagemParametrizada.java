package br.edu.fema.projetopadrao.utils.mensagem.service;

import java.time.LocalDateTime;

import br.edu.fema.projetopadrao.utils.mensagem.enums.Acao;
import br.edu.fema.projetopadrao.utils.mensagem.enums.Prioridade;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Classe responsável por definir os
 * parâmetros da mensagem que será enviada
 * ao(s) usuários <br>
 * Na versão 1.1 esta classe passou por revisão
 * e incorporação das anotações do Lombok
 * 
 * @author CEPEIN - cepeinfema@gmail.com
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * 
 * @since 2018
 * @version 1.1 - 19/05/2022
 *
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class MensagemParametrizada {
	
	private String texto;
	private String nomeRemetente;
	private String loginDestinatario;
	private Prioridade prioridade;	
	private Boolean apagavel; 
	private Acao acao;
	private LocalDateTime prazoValidade;
}
