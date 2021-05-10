package com.orange.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orange.cadastro.model.Endereco;
import com.orange.cadastro.repository.EnderecoRepositorio;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepositorio er;
	
	public void salvarEndereco(Endereco endereco) {
			er.save(endereco);
	}
}
