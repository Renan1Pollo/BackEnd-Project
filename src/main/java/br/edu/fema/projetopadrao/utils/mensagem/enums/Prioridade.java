package br.edu.fema.projetopadrao.utils.mensagem.enums;

public enum Prioridade {
	
	URGENTE("0"), ALTA("1"), MEDIA("2"), BAIXA("3");
	
	private String prioridade;
	
	Prioridade(String prioridade){
		this.prioridade = prioridade;
	}
	
	public String getPrioridade() {
		return this.prioridade;
	}

}
