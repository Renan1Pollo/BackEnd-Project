package br.edu.fema.projetopadrao.seguranca.dto;


public class RequisicaoInvalidaDTO {

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public RequisicaoInvalidaDTO(String mensagem) {
        super();
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"mensagem\" : ");
        stringBuilder.append("\""+this.mensagem+"\"");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
    
    
}