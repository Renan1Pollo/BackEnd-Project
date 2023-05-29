package br.edu.fema.projetopadrao.utils.apagarArquivos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aplicacao", schema = "upload")
@Getter
@NoArgsConstructor
public class AplicacaoDownloadUpload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aplicacao")
	private Long id;

	@NotNull
	@Size(max = 50)
	@Column(name = "nome")
	private String nome;

	@NotNull
	@Size(max = 30)
	@Column(name = "nome_tabela")
	private String nomeTabela;

	@NotNull
	@Column(name = "tamanho_arquivo")
	private Long tamanhoArquivo;

	@NotNull
	@Size(max = 300)
	@Column(name = "extensoes_aceitas")
	private String extensoesAceitas;
}
