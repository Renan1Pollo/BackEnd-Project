package br.edu.fema.projetopadrao.utils.apagarArquivos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fema.projetopadrao.utils.apagarArquivos.model.AplicacaoDownloadUpload;
import br.edu.fema.projetopadrao.utils.apagarArquivos.repository.ApagarArquivoRepositoryJDCBC;
import br.edu.fema.projetopadrao.utils.apagarArquivos.repository.AplicacaoDownloadUploadRepository;

/**
 * 
 * Serviço responsável pela exclusão lógica
 * de um arquivo no banco de dados
 * 
 * @author CEPEIN - cepeinfema@gmail.com
 * 
 * @since 2018
 * @version 1.0
 *
 */
@Service
public class ApagarArquivosService {

	@Autowired
	private AplicacaoDownloadUploadRepository aplicacaoRepository;
	
	@Autowired
	private ApagarArquivoRepositoryJDCBC apagarArquivoRepositoryJDCBC;
	
	/**
	 * Método que busca a aplicação 
	 * usado para o metodo de excluir arquivo
	 * @param idAplicacao - {@code Long}
	 * @return Aplicacao - {@link AplicacaoDownloadUpload}
	 */
	public AplicacaoDownloadUpload buscarInformacoesAplicacao(Long idAplicacao) {
		Optional<AplicacaoDownloadUpload> aplicacao = this.aplicacaoRepository.findById(idAplicacao);
		if (!aplicacao.isPresent())
			throw new IllegalArgumentException("Aplicacao não cadastrada!");
		return aplicacao.get();
	}
	
	/**
	 * Método responsável pela exclusão lógica
	 * de um arquivo
	 * 
	 * @param idAplicacao - {@code Long}
	 * @param uuidArquivo - {@code String}
	 */
	public void excluirLogicamenteArquivo(Long idAplicacao, String uuidArquivo) {
		AplicacaoDownloadUpload aplicacao = this.buscarInformacoesAplicacao(idAplicacao);
		this.apagarArquivoRepositoryJDCBC.excluirLogicamenteArquivo(aplicacao.getNomeTabela(), uuidArquivo);
	}
}
