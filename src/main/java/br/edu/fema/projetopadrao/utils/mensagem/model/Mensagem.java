package br.edu.fema.projetopadrao.utils.mensagem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.edu.fema.projetopadrao.utils.mensagem.enums.Acao;
import br.edu.fema.projetopadrao.utils.mensagem.enums.Prioridade;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Luis Franco
 *
 * Classe de modelo responsável por mapear a tabela web_mensagens.
 */
@Entity
@Table(name = "web_mensagens", schema="restrito")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Mensagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mensagem")
	private Long id;

	@Column(name = "codigo_sistema")
	private Integer codigoSistema;

	@Column(name = "login_remetente")
	@Size(max = 20)
	private String loginRemetente;

	@Column(name="id_departamento")
	private Long idDepartamento;
	
	@Size(max = 100)
	private String remetente;

	@Column(name = "data_inclusao")
	@Size(max = 10)
	private String dataInclusao;

	@Column(name = "login_destinatario")
	@Size(max = 20)
	private String loginDestinatario;

	@Column(name = "data_leitura")
	@Size(max = 20)
	private String dataLeitura;

	@NotNull
	private String mensagem;

	@NotNull
	private Prioridade prioridade;

	@Size(max = 1)
	private String apagar;

	@NotNull
	private Acao acao;

	@Column(name = "prazo_validade")
	@Size(max = 20)
	private String prazoValidade;

	@Size(max = 1)
	private String situacao;
}
