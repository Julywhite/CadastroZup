package com.orange.cadastro.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.orange.cadastro.model.Cliente;
import com.orange.cadastro.model.Endereco;

public class EnderecoDtoRequisicao {
	
	@NotBlank(message = "Obrigatório preencher Logradouro!")
	@Size(min = 2, message = "Logradouro inválido!")
	private String logradouro;
	
	@NotBlank(message = "Obrigatório preencher Número!")
	private String numero;
	
	@NotBlank(message = "Obrigatório preencher Bairro!")
	@Size(min = 2, message = "Bairro inválido!")
	private String bairro;
	
	@NotBlank(message = "Obrigatório preencher Cidade!")
	@Size(min = 2, message = "Cidade inválida!")
	private String cidade;
	
	@NotBlank(message = "Obrigatório preencher Estado!")
	@Size(min = 2, max = 2, message = "Estado inválido!")
	private String estado;
	
	@NotBlank(message = "Obrigatório preencher CEP!")
	@Size(min = 9, message = "CEP inválido!")
	private String cep;
	
	@NotNull(message = "Obrigatório preencher Cliente!")
	private Cliente cliente;

	
	
	public Endereco converteEndereco() {
		return new Endereco(logradouro, numero, bairro, cidade, estado, cep, cliente);
	}
	
	

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
