package com.orange.cadastro;

import com.orange.cadastro.dto.ClienteDtoRequisicao;
import com.orange.cadastro.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class TesteCliente {

    @Test
    public void criarCliente() {

        String nome = "Ana Maria";
        String email = "teste@outlook.com";
        String cpf = "597.579.090-50";
        LocalDate dataNasc = LocalDate.parse("1991-01-01");

        Cliente cliente = new Cliente(nome, email, cpf, dataNasc);

        Assertions.assertNotNull( cliente );
    }

    @Test
    public void testaMetodoDtoConverteCliente() {

        String nome = "Ana Maria";
        String email = "teste@outlook.com";
        String cpf = "597.579.090-50";
        LocalDate dataNasc = LocalDate.parse("1991-01-01");

        ClienteDtoRequisicao dto = new ClienteDtoRequisicao(nome, email, cpf, dataNasc);

        Cliente cli = dto.converteCliente();

    }
}
