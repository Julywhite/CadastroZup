package com.orange.cadastro;

import com.orange.cadastro.dto.ClienteDtoRequisicao;
import com.orange.cadastro.model.Cliente;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


public class TesteCliente {

    Cliente cliente;

    @BeforeEach
    public void instanciaClienteParaTestes() {

        String nome = "Ana Maria", email = "teste@outlook.com", cpf = "597.579.090-50";
        LocalDate dataNasc = LocalDate.parse("1991-01-01");

        cliente = new Cliente(nome, email, cpf, dataNasc);
    }


    @Test
    @DisplayName("Testar criação de cliente")
    public void criarCliente() {

        Assertions.assertThat( cliente ).isNotNull();
    }

    @Test
    @DisplayName("Testar método converteCliente da classe ClienteDtoRequeisição")
    public void metodoDtoConverteCliente() {

        String nome = "Ana Maria", email = "teste@outlook.com", cpf = "597.579.090-50";
        LocalDate dataNasc = LocalDate.parse("1991-01-01");

        ClienteDtoRequisicao dto = new ClienteDtoRequisicao(nome, email, cpf, dataNasc);

        Assertions.assertThat( dto.converteCliente() ).hasSameClassAs( cliente );
    }

    @Test
    @DisplayName("Testar ClienteService se está salvando corretamente")
    public void salvaCliente() {


        //Assertions.assertThat( cli.getCpf() ).isEqualTo( "597.579.090-50" );
    }
}
