package dev.imrob.tutorialcrud.controller;

import dev.imrob.tutorialcrud.dto.ClienteDTO;
import dev.imrob.tutorialcrud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<ClienteDTO> findByCpf(@PathVariable("cpf") String cpf) {
        return ResponseEntity.ok(service.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(service.save(clienteDTO));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody ClienteDTO clienteDTO) {
        service.update(clienteDTO);
        return ResponseEntity.ok("Atualização realizada com sucesso!");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Cliente deletado com sucesso!");
    }
}
