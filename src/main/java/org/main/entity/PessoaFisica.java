package org.main.entity;

import lombok.*;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;



@Inheritance(strategy = InheritanceType.JOINED)
@Table (name = "pessoa_fisica")
@Entity
public @Data abstract class PessoaFisica implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column
    private String email;

    @Column
    private String telefone;

}
