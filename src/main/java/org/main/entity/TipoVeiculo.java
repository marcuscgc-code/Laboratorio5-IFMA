package org.main.entity;

import lombok.*;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@NoArgsConstructor @AllArgsConstructor
@Table(name = "tipo_veiculo")
@Entity
public @Data class TipoVeiculo implements EntidadeBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String descricao;

    @Column(name = "peso_maximo")
    private BigDecimal pesoMaximo;
}
