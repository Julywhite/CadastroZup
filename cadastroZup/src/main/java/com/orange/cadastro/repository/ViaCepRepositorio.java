package com.orange.cadastro.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.orange.cadastro.model.EnderecoViaCep;

@FeignClient(name = "ViaCep", url = "https://viacep.com.br/ws")
public interface ViaCepRepositorio {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
	EnderecoViaCep pegaEnderecoPorCep(@PathVariable("cep") String cep);
}
