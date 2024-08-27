package org.main.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id
    private String cpf;

    private String contato;

    private Boolean ativo;

    @Override
    public Integer getId() {
        return cpf != null ? cpf.hashCode() : null;
    }
}
