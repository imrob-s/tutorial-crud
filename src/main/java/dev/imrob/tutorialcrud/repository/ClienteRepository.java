package dev.imrob.tutorialcrud.repository;

import dev.imrob.tutorialcrud.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends ListCrudRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);
}
