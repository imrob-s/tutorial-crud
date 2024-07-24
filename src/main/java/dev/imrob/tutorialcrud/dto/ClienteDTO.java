package dev.imrob.tutorialcrud.dto;

import dev.imrob.tutorialcrud.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public record ClienteDTO (
        Long id,
        String nome,
        String rg,
        String cpf,
        String cnh,
        LocalDate cnhVencimento,
        String email,
        String telefone,
        Endereco endereco
){}
