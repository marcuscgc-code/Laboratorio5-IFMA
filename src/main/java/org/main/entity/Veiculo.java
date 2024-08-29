package org.main.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id
    private String numeroPlaca;

    @ManyToOne
    @JoinColumn(name = "filialNome")
    private Filial filial;

    @ManyToOne
    @JoinColumn(name = "tipoVeiculoId")
    private TipoVeiculo tipoVeiculo;

    @Override
    public Integer getId() {
        return numeroPlaca != null ? numeroPlaca.hashCode() : null;
    }
}
