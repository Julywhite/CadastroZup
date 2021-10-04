package com.orange.cadastro;

import com.orange.cadastro.Exceptions.ValorDivergente;
import com.orange.cadastro.dto.EnderecoDtoRequisicao;
import com.orange.cadastro.model.Cliente;
import com.orange.cadastro.model.Endereco;
import com.orange.cadastro.model.EnderecoViaCep;
import com.orange.cadastro.repository.ViaCepRepositorio;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class TesteEndereco {

    Endereco endereco;
    EnderecoDtoRequisicao endRequisicao;

    @Mock
    Cliente cliente;

    @BeforeEach
    public void intanciaEnderecoParaTeste() {

        cliente = Mockito.mock( Cliente.class );
        ViaCepRepositorio vcp = null;

        String rua = "Rua Igarapeba", num = "35A", bairro = "COHAB", cidade = "Recife", estado = "PE", cep = "51330270";

        endereco = new Endereco( rua, num, bairro, cidade, estado, cep, cliente );
        endRequisicao = new EnderecoDtoRequisicao( rua, num, bairro, cidade, estado, cep, cliente );
    }

    @Test
    @DisplayName("Método converteEndereco da EnderecoDtoRequisição deve retornar um Endereco")
    public void metodoDtoConverteEndereco() {

        Endereco teste = endRequisicao.converteEndereco();

        Assertions.assertThat( teste ).isNotNull();
    }

    @Test
    @DisplayName( "Conferir dados do endereço 'salvo'" )
    public void validaEnderecoSalvo() {

        Assertions.assertThat( endereco.getBairro() ).isEqualTo( "COHAB" );
    }

    @Test
    @DisplayName("Validar se Logradouro informado confere com o da API ViaCep")
    public void validaCepInformadoPeloViaCep() {

        EnderecoViaCep viaCep = new EnderecoViaCep();
        viaCep.setLogradouro("Rua diferente");

        assertThrows( ValorDivergente.class, ()-> {

            if (!endereco.getLogradouro().equalsIgnoreCase( viaCep.getLogradouro() )) {
                throw new ValorDivergente("Nome não confere com CEP informado");
            }
        } );
    }
}
