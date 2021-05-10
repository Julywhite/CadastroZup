package com.orange.cadastro.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orange.cadastro.model.Cliente;
import com.orange.cadastro.model.Endereco;
import com.orange.cadastro.repository.ClienteRepositorio;
import com.orange.cadastro.repository.EnderecoRepositorio;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepositorio cr;
	
	@Autowired
	EnderecoRepositorio er;

	public Cliente salvarCliente(Cliente cliente) {
		 return cr.save(cliente);
	}
	
	public Cliente consultarTodosEnderecosCliente(int id){
		List<Endereco> listarTodos = new ArrayList<>();
		Cliente cliente = cr.findById(id).get();
		er.findByCliente(cliente).forEach(ender -> listarTodos.add(ender));
		cliente.setEnderecos(listarTodos);
		
		return cliente;
	}
}
