package com.orange.cadastro.controller;

import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orange.cadastro.Exceptions.ValorNaoEncontrado;
import com.orange.cadastro.dto.ClienteDtoRequisicao;
import com.orange.cadastro.dto.ClienteDtoResposta;
import com.orange.cadastro.model.Cliente;
import com.orange.cadastro.service.ClienteService;
import com.orange.cadastro.service.EnderecoService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
		
	@Autowired
	ClienteService cs;
	
	@Autowired
	EnderecoService es;

	@PostMapping
	public ResponseEntity<ClienteDtoResposta> salvaCliente(@RequestBody @Valid ClienteDtoRequisicao dto) {
		Cliente cliente = dto.converteCliente();
		cs.salvarCliente(cliente);
		return new ResponseEntity<>(new ClienteDtoResposta(cliente), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ClienteDtoResposta consultarTodosEnderecosCliente(@PathVariable("id") int id) {
		Cliente cliente = null;
		try {
			cliente = cs.consultarTodosEnderecosCliente(id);
		} catch(NoSuchElementException e) {
			throw new ValorNaoEncontrado("Cliente não foi encontrado!");
		}
		return new ClienteDtoResposta(cliente);
	}
}

