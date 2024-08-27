package org.main.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PessoaFisica implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id
    private String cpf;

    private String nome;

    private String email;

    private String telefone;

    @Override
    public Integer getId() {
        // Considerando que CPF é a chave primária, podemos retornar um hashcode como id único.
        return cpf != null ? cpf.hashCode() : null;
    }
}
