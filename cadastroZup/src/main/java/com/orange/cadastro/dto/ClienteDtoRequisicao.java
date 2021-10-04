package com.orange.cadastro.dto;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.orange.cadastro.model.Cliente;

public class ClienteDtoRequisicao {

	@NotBlank(message = "Obrigatório preencher Nome!")
	@Size(min = 2, max = 100, message = "Nome inválido!")
	private String nome;
	
	@NotBlank(message = "Obrigatório preencher CPF!")
	@Size(min = 14, message = "CPF inválido!")
	private String cpf;
	
	@NotBlank(message = "Obrigatório preencher Email!")
	@Email(message = "Email inválido!")
	private String email;
	
	@NotNull(message = "Obrigatório preencher data de nascimento!")
	private LocalDate dataNascimento;
	
	
	public Cliente converteCliente() {
		return new Cliente(nome, cpf, email, dataNascimento);
	}

	public ClienteDtoRequisicao(String nome, String cpf, String email, LocalDate data) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
