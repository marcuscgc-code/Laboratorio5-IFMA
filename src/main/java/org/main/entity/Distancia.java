package org.main.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@IdClass(Distancia.DistanciaId.class)
public class Distancia implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "cidadeOrigemUf", referencedColumnName = "uf"),
            @JoinColumn(name = "cidadeOrigemNome", referencedColumnName = "nome")
    })
    private Cidade cidadeOrigem;

    @EqualsAndHashCode.Include
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "cidadeDestinoUf", referencedColumnName = "uf"),
            @JoinColumn(name = "cidadeDestinoNome", referencedColumnName = "nome")
    })
    private Cidade cidadeDestino;

    private Integer quilometros;

    @Override
    public Integer getId() {
        // Usando um hashcode das chaves compostas para representar o ID
        return (cidadeOrigem.getUf() + cidadeOrigem.getNome() +
                cidadeDestino.getUf() + cidadeDestino.getNome()).hashCode();
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class DistanciaId implements Serializable {
        private String cidadeOrigemUf;
        private String cidadeOrigemNome;
        private String cidadeDestinoUf;
        private String cidadeDestinoNome;
    }
}
