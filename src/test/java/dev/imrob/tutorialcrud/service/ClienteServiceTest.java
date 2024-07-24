package dev.imrob.tutorialcrud.service;

import dev.imrob.tutorialcrud.dto.ClienteDTO;
import dev.imrob.tutorialcrud.entity.Cliente;
import dev.imrob.tutorialcrud.exceptions.ClienteNotFoundException;
import dev.imrob.tutorialcrud.mapper.ClienteMapper;
import dev.imrob.tutorialcrud.repository.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    private ClienteService service;

    @Mock
    private ClienteRepository repository;

    @Mock
    private ClienteMapper mapper;

    @Test
    @DisplayName("Este teste verifica se um cliente válido foi deletado")
    void delete_deveDeletarCliente_quandoClienteExistir() {
        // Preparar o teste unitario
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Robson");
        cliente.setCpf("111.111.111-11");
        cliente.setCnhVencimento(LocalDate.now());

        // Fazemos os mocks
        when(repository.findById(1L)).thenReturn(Optional.of(cliente));

        // Realiza o Teste
        assertDoesNotThrow(() -> service.delete(1L));
    }

    @Test
    void delete_deveRetornarException_quandoClienteInexistente() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.delete(43L))
                .isInstanceOf(ClienteNotFoundException.class);
                //.hasMessageContaining("Cliente com id 43 não foi encontrado");
    }

    @Test
    void findByCpf_deveRetornarCliente_quandoCpfValido() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Robson");
        cliente.setCpf("111.111.111-11");
        cliente.setCnhVencimento(LocalDate.now());

        ClienteDTO clienteDTO = new ClienteDTO(2L,
                "Robson",
                "111.111.111-11",
                "123456789",
                null,null, null, null, null);

        Optional<Cliente> clienteOptional = Optional.of(cliente);

        when(repository.findByCpf("111.111.111-11")).thenReturn(clienteOptional);
        when(mapper.toDto(cliente)).thenReturn(clienteDTO);

        ClienteDTO resultado = service.findByCpf("111.111.111-11");

        assertEquals(clienteDTO, resultado);
        assertNotNull(resultado);
        assertEquals(clienteDTO.id(), resultado.id());
        assertEquals(clienteDTO.nome(), resultado.nome());
        assertEquals(clienteDTO.cpf(), resultado.cpf());
        assertEquals(clienteDTO.cnhVencimento(), resultado.cnhVencimento());
    }

}