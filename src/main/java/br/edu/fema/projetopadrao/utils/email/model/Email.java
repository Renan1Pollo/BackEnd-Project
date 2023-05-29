package br.edu.fema.projetopadrao.utils.email.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Email {

	private String remetente;

	@NotNull(message = "campo assunto não pode estar nullo!")
	@NotEmpty(message = "campo assunto não pode estar vazio!")
	private String assunto;

	@NotNull(message = "campo mensagem não pode estar nullo!")
	@NotEmpty(message = "campo mensagem não pode estar vazio!")
	private String mensagem;

	private String[] emails;
}
