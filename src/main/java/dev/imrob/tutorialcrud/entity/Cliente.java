package dev.imrob.tutorialcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    private Long id;
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private LocalDate cnhVencimento;
    private String email;
    private String telefone;
    @Column("id")
    private Endereco endereco;
}
