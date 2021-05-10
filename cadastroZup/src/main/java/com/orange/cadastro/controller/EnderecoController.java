package com.orange.cadastro.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orange.cadastro.Exceptions.ValorDivergente;
import com.orange.cadastro.Exceptions.ValorNaoEncontrado;
import com.orange.cadastro.dto.EnderecoDtoRequisicao;
import com.orange.cadastro.dto.EnderecoDtoResposta;
import com.orange.cadastro.model.Endereco;
import com.orange.cadastro.model.EnderecoViaCep;
import com.orange.cadastro.repository.ViaCepRepositorio;
import com.orange.cadastro.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService es;
	
	@Autowired
	ViaCepRepositorio vcr;
	
	@PostMapping
	public ResponseEntity<EnderecoDtoResposta> salvarEndereco(@RequestBody @Valid EnderecoDtoRequisicao dto) {
		Endereco endereco;
		EnderecoViaCep enderecoVC;
		
		try {
			endereco = dto.converteEndereco();
			enderecoVC = vcr.pegaEnderecoPorCep(endereco.getCep());
			
			if (enderecoVC.getUf().equalsIgnoreCase(endereco.getEstado())) {
				if(enderecoVC.getLocalidade().equalsIgnoreCase(endereco.getCidade())) {
					if(enderecoVC.getBairro().equalsIgnoreCase(endereco.getBairro())) {
						if(enderecoVC.getLogradouro().equalsIgnoreCase(endereco.getLogradouro())) {
							
							es.salvarEndereco(endereco);
							return new ResponseEntity<>(new EnderecoDtoResposta(endereco), HttpStatus.CREATED);
							
						}else {throw new ValorDivergente("Logradouro não confere com CEP informado!");}
					}else {throw new ValorDivergente("Bairro não confere com CEP informado!");}
				}else {throw new ValorDivergente("Cidade não confere com CEP informado!");}
			}else {throw new ValorDivergente("Estado não confere com CEP informado!");}
			
		}catch(NullPointerException e) {
			throw new ValorNaoEncontrado("CEP não foi encontrado!");
		}
	}
	
}

