package org.main.entity;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table (name = "dependente")
@Entity
public @Data class Dependente implements EntidadeBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn(name="id_funcionario")
    private Funcionario funcionario;

    @Column (nullable = false)
    private String nome;

    @Column (name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Override
    public Integer getId() {
        return id;
    }
}
