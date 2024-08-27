package org.main.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Dependente implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "matriculaFuncionario")
    private Funcionario funcionario;

    @Override
    public Integer getId() {
        return id;
    }
}
