package com.orange.cadastro.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RespostaCustomizada extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ValorNaoEncontrado.class)
	  public final ResponseEntity<RespostaExcessao> CustomizaResposta(ValorNaoEncontrado e, WebRequest request) {
	    RespostaExcessao resposta = new RespostaExcessao(e.getMessage());

	    return new ResponseEntity<RespostaExcessao>(resposta, HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(ValorDivergente.class)
	  public final ResponseEntity<RespostaExcessao> CustomizaResposta(ValorDivergente e, WebRequest request) {
	    RespostaExcessao resposta = new RespostaExcessao(e.getMessage());

	    return new ResponseEntity<RespostaExcessao>(resposta, HttpStatus.BAD_REQUEST);
	  }
	
//	@ExceptionHandler(ValorDivergente.class)
//	  public final ResponseEntity<RespostaExcessao> CustomizaResposta(ValorDivergente e, WebRequest request) {
//	    RespostaExcessao resposta = new RespostaExcessao(new Date(),
//														e.getMessage()
//														request.getDescription(false)
//														HttpStatus.BAD_REQUEST.getReasonPhrase()
//														);
//
//	    return new ResponseEntity<RespostaExcessao>(resposta, HttpStatus.BAD_REQUEST);
//	  }
}
