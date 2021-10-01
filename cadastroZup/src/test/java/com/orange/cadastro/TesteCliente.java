package com.orange.cadastro;

import com.orange.cadastro.dto.ClienteDtoRequisicao;
import com.orange.cadastro.model.Cliente;
import com.orange.cadastro.model.Endereco;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@ExtendWith(MockitoExtension.class)
public class TesteCliente {

    Cliente cliente;
    ClienteDtoRequisicao dto;

    @Mock
    List<Endereco> lista;

    @BeforeEach
    public void instanciaClienteParaTestes() {

        String nome = "Ana Maria", email = "teste@outlook.com", cpf = "597.579.090-50";
        LocalDate dataNasc = LocalDate.parse("1991-01-01");

        cliente = new Cliente( nome, cpf, email, dataNasc );
        dto = new ClienteDtoRequisicao( nome, cpf, email, dataNasc );

    }

    @Test
    @DisplayName("Método converteCliente da ClienteDtoRequisição deve retornar um Cliente")
    public void metodoDtoConverteCliente() {

        Assertions.assertThat( dto.converteCliente() ).hasSameClassAs( cliente );
    }

    @Test
    public void testaOutraCoisa() {

        Cliente cli = dto.converteCliente();

        Assertions.assertThat( cli.getCpf().toString() ).isEqualTo( "597.579.090-50" );
    }

    @Test
    @DisplayName("Testar add endereço à lista de Cliente")
    public void adicionaEnderecoAoCliente() {

        lista = Mockito.mock( ArrayList.class );
        Mockito.when( lista.size() ).thenReturn( 1 );

        cliente.setEnderecos( lista );

        Assertions.assertThat( cliente.getEnderecos().size() ).isEqualTo( 1 );
    }
}
