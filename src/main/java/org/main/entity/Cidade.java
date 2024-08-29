package org.main.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@IdClass(Cidade.CidadeId.class)
public class Cidade implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id
    private String uf;

    @EqualsAndHashCode.Include
    @Id
    private String nome;

    private String estado;

    @Override
    public Integer getId() {
        return (uf + nome).hashCode();
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class CidadeId implements Serializable {
        private String uf;
        private String nome;
    }
}
