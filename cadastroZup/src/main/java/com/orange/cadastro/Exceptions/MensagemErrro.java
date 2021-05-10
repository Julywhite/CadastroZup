package com.orange.cadastro.Exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MensagemErrro{

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> validationException(MethodArgumentNotValidException ex){
		
		Map<String, String> erros = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((erro) -> {

			String nomeCampo = ((FieldError) erro).getField();
			String mensagemErro = erro.getDefaultMessage();
			erros.put(nomeCampo, mensagemErro);
		});
		return erros;
	}
}
