package com.orange.cadastro.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.orange.cadastro.model.Cliente;
import com.orange.cadastro.model.Endereco;

public class ClienteDtoResposta {

	private int id;
	private String nome;
	private String cpf;
	private String email;
	private LocalDate dataNascimento;
	private List<EnderecoDtoResposta> enderecos = new ArrayList<>();
	
	public ClienteDtoResposta(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		this.dataNascimento = cliente.getDataNascimento();
		this.enderecos = converteListaDto(cliente.getEnderecos());
	}

	public static List<EnderecoDtoResposta> converteListaDto(List<Endereco> enderecos){
		return enderecos.stream().map(EnderecoDtoResposta::new).collect(Collectors.toList());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<EnderecoDtoResposta> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDtoResposta> enderecos) {
		this.enderecos = enderecos;
	}
}
