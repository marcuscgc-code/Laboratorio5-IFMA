package org.main.entity;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Table (name = "distancia")
@Entity
public @Data class Distancia implements EntidadeBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_cidade_origem")
    private Cidade cidadeOrigem;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_cidade_destino")
    private Cidade cidadeDestino;

    @Column
    private Integer quilometros;

}
