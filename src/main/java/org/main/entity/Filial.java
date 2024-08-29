package org.main.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Filial implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id
    private String nome;

    private String endereco;

    private String telefone;

    @Override
    public Integer getId() {
        return nome != null ? nome.hashCode() : null;
    }
}
