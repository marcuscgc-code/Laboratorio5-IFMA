package org.main.entity;

import lombok.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.math.BigDecimal;


@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@IdClass(Distancia.DistanciaId.class)
public @Data class Distancia implements EntidadeBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cidade_origem")
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "id_cidade_destino")
    private Cidade cidadeDestino;

    @Column
    private Integer quilometros;


    //SOBRESCREVENDO DOT -- chamando construtores


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
