package dev.imrob.tutorialcrud.service;

import dev.imrob.tutorialcrud.dto.ClienteDTO;
import dev.imrob.tutorialcrud.entity.Cliente;
import dev.imrob.tutorialcrud.exceptions.ClienteNotFoundException;
import dev.imrob.tutorialcrud.mapper.ClienteMapper;
import dev.imrob.tutorialcrud.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteDTO findById(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(
                () -> new ClienteNotFoundException("Cliente com id " + id + " não foi encontrado"));
        return mapper.toDto(cliente);
    }
    public ClienteDTO findByCpf(String cpf) {
        Optional<Cliente> clienteOptional = repository.findByCpf(cpf);
        if (clienteOptional.isEmpty()) {
            throw new ClienteNotFoundException("Cliente com cpf " + cpf + " não foi encontrado");
        }
        Cliente cliente = clienteOptional.get();

        return mapper.toDto(cliente);
    }

    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = repository.findAll();
        return mapper.toDto(clientes);
    }

    public Long save(ClienteDTO clienteDTO) {
        Cliente cliente = mapper.toEntity(clienteDTO);
        cliente = repository.save(cliente);
        return cliente.getId();
    }

    public void update(ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = repository.findById(clienteDTO.id());
        if (clienteOptional.isEmpty()) {
            throw new ClienteNotFoundException("Cliente com id " + clienteDTO.id() + " não foi encontrado");
        }
        Cliente cliente = mapper.toEntity(clienteDTO);
        repository.save(cliente);
    }

    public void delete(Long id) {
//        Cliente cliente = repository.findById(id).orElseThrow(
//                () -> new ClienteNotFoundException("Cliente com id "+ id +" não foi encontrado"));
//        repository.delete(cliente);

        Optional<Cliente> clienteOptional = repository.findById(id);

        if (clienteOptional.isPresent()){
            repository.delete(clienteOptional.get());
        } else {
            throw new ClienteNotFoundException("Cliente com id "+ id +" não foi encontrado");
        }
    }
}
