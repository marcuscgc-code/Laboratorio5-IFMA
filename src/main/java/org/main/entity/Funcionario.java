package org.main.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Funcionario implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matricula;

    @ManyToOne
    @JoinColumn(name = "cpf")
    private PessoaFisica pessoaFisica;

    @Override
    public Integer getId() {
        return matricula;
    }
}
