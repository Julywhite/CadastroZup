package com.orange.cadastro.Exceptions;

public class ValorNaoEncontrado  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ValorNaoEncontrado (String mensagem) {
		 super(mensagem);
	}
}
