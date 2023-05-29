package br.edu.fema.projetopadrao.utils.email.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * Componente responsável por encaminhar
 * o e-mail de acordo com as configurações 
 * pré definidas aos destinatários informados
 * 
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 2018
 * @version 1.0
 *
 */
@Component
public class GerarEmail implements Serializable {

	@Value("${email.servidor_smtp}")
	private String servidorSmtp;

	@Value("${email.conta_padrao}")
	private String contaPadrao;

	@Value("${email.nome_padrao}")
	private String nomePadrao;

	@Value("${email.senha_padrao}")
	private String senhaContaPadrao;

	@Value("${email.email_adm}")
	private String emailAdm;

	@Value("${email.porta_padrao}")
	private int portaPadrao;

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Método responsável por encaminhar o e-mail
	 * aos destinatários de acordo com os parâmetros
	 * pré definidos
	 * 
	 * @param remetente - {@code String}
	 * @param assunto - {@code String}
	 * @param mensagem - {@code String}
	 * @param emails - {@code String[]}
	 * @throws EmailException - Caso ocorra algum erro
	 * ao enviar o e-mail ao(s) destinatário(s)
	 */
	public void enviarEmailListaDestinatarios(String remetente, String assunto, String mensagem, String[] emails)
			throws EmailException {
		try {
			SimpleEmail email = new SimpleEmail();
			email.setCharset("UTF-8");
			email.setSmtpPort(portaPadrao);
			email.setHostName(servidorSmtp);
			email.setAuthentication(contaPadrao, senhaContaPadrao);
			List<String> listaEmails = new ArrayList<>();
			for (String lst1 : emails) {
				email.addTo(lst1, lst1);
				listaEmails.add(lst1);

			}
			email.setMsg("De : " + remetente + " Para : " + listaEmails + "\n\n" + mensagem);
			email.setFrom(remetente, remetente);
			email.setSubject(assunto);
			email.send();
		} catch (EmailException ex) {
			throw new EmailException("Erro ao gerar email: " + ex);
		}
	}
}
