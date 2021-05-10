package com.orange.cadastro.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.orange.cadastro.model.Cliente;
import com.orange.cadastro.model.Endereco;

public interface EnderecoRepositorio extends CrudRepository<Endereco, Integer>{

	public List<Endereco> findByCliente(Cliente cliente);
}
