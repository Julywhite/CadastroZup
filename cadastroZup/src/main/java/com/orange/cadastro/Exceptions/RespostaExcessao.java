package com.orange.cadastro.Exceptions;

public class RespostaExcessao {

	 private String mensagem;

	 
	public RespostaExcessao(String mensagem) {
		this.mensagem = mensagem;
	}
	
//	public RespostaExcessao(Date dataHora, String mensagem, String detalhes, String tipoErro) {
//		this.dataHora = dataHora;
//		this.mensagem = mensagem;
//		this.detalhes = detalhes;
//		this.tipoErro = tipoErro;
//	}


	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
