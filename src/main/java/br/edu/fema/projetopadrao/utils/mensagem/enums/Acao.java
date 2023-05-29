package br.edu.fema.projetopadrao.utils.mensagem.enums;

public enum Acao {
	
	NENHUMA("0"), ARQUIVAR("1"), EXCLUIR("2"), MARCAR_COMO_LIDA("3");
	
	private String acao;
	
	Acao(String acao){
		this.acao = acao;
	}
	
	public String getPrioridade() {
		return this.acao;
	}

}
