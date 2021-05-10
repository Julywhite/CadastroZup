package com.orange.cadastro.Exceptions;

public class ValorDivergente extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ValorDivergente (String mensagem) {
		 super(mensagem);
	}
}
