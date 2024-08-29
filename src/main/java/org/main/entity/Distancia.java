package org.main.entity;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@IdClass(Distancia.DistanciaId.class)
public class Distancia implements EntidadeBase {

    @Id
    @Column(name = "cidadeOrigemUf")
    private String cidadeOrigemUf;

    @Id
    @Column(name = "cidadeOrigemNome")
    private String cidadeOrigemNome;

    @Id
    @Column(name = "cidadeDestinoUf")
    private String cidadeDestinoUf;

    @Id
    @Column(name = "cidadeDestinoNome")
    private String cidadeDestinoNome;

    private Integer quilometros;

    @Override
    public Integer getId() {
        // Usando um hashcode das chaves compostas para representar o ID
        return (cidadeOrigemUf + cidadeOrigemNome +
                cidadeDestinoUf + cidadeDestinoNome).hashCode();
    }

    @Data @NoArgsConstructor @AllArgsConstructor
    public static class DistanciaId implements Serializable {
        private String cidadeOrigemUf;
        private String cidadeOrigemNome;
        private String cidadeDestinoUf;
        private String cidadeDestinoNome;

        // Implementar equals e hashCode para DistanciaId
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DistanciaId that = (DistanciaId) o;
            return cidadeOrigemUf.equals(that.cidadeOrigemUf) &&
                    cidadeOrigemNome.equals(that.cidadeOrigemNome) &&
                    cidadeDestinoUf.equals(that.cidadeDestinoUf) &&
                    cidadeDestinoNome.equals(that.cidadeDestinoNome);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cidadeOrigemUf, cidadeOrigemNome, cidadeDestinoUf, cidadeDestinoNome);
        }
    }
}
