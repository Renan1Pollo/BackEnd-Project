package br.edu.fema.projetopadrao.utils.email.service;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.fema.projetopadrao.utils.email.model.Email;
import br.edu.fema.projetopadrao.utils.email.model.GerarEmail;

/**
 * 
 * Serviço responsável por realizar o envio
 * de e-mail de acordo com os parâmetros 
 * passados de {@link Email}
 * 
 * @author CEPEIN - cepeinfema@gmail.com
 *
 * @since 2018
 * @version 1.0
 *
 */
@Service
public class EmailService {

	@Autowired
	private GerarEmail gerarEmail;

	/**
	 * Metodo que faz o envio de um e-mail para uma lista de destinatarios;
	 * 
	 * @param remetente String
	 * @param email     EmailModel
	 */
	public void enviarEmail(String remetente, Email email) {
		try {
			gerarEmail.enviarEmailListaDestinatarios(remetente, email.getAssunto(), email.getMensagem(),
					email.getEmails());
		} catch (EmailException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro:" + e);
		}
	}
}
