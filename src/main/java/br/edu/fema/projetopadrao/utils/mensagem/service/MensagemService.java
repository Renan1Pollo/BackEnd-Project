package br.edu.fema.projetopadrao.utils.mensagem.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fema.projetopadrao.utils.conversao.dataHora.LocalDateTimeUtils;
import br.edu.fema.projetopadrao.utils.conversao.dataHora.LocalDateUtils;
import br.edu.fema.projetopadrao.utils.mensagem.model.Mensagem;
import br.edu.fema.projetopadrao.utils.mensagem.repository.MensagemRepository;

/**
 * 
 * Serviço responsável por enviar a mensagem
 * definida pela {@link MensagemParametrizada}
 * ao usuário <br>
 * Na versão 1.1 esta classe passou por refatoração
 * do método de gravação da mensagem. Passou a ser
 * utilizado o padrão de projeto Builder
 * 
 * @author CEPEIN - cepeinfema@gmail.com
 * @author Paulo Romano - paulo-romano_133@hotmail.com
 * 
 * @since 2018
 * @version 1.1 - 19/05/2022
 *
 */
@Service
public class MensagemService {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	
	public Mensagem gravarMensagem(MensagemParametrizada mensagemParametrizada) {
		String prazoValidade = Objects.isNull(mensagemParametrizada.getPrazoValidade()) ? "N" 
				: LocalDateTimeUtils.converterLocalDateTimeHoraMinutoParaString(mensagemParametrizada.getPrazoValidade());
		
		Mensagem mensagem = Mensagem.builder()
				.dataInclusao(LocalDateUtils.converterLocalDateAtualParaString())
				.loginDestinatario(mensagemParametrizada.getLoginDestinatario())
				.loginRemetente("VIA SISTEMA")
				.mensagem(mensagemParametrizada.getTexto())
				.prioridade(mensagemParametrizada.getPrioridade())
				.situacao("0")
				.dataLeitura("N")
				.codigoSistema(0)
				.idDepartamento(1L)
				.apagar(mensagemParametrizada.getApagavel() ? "S" : "N")
				.acao(mensagemParametrizada.getAcao())
				.remetente(mensagemParametrizada.getNomeRemetente())
				.prazoValidade(prazoValidade)
				.build();

		return this.mensagemRepository.save(mensagem);
	}
}
