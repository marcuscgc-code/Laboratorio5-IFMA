package org.main.entity;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.HashSet;



@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table (name = "cidade")
@IdClass(Cidade.CidadeId.class)
public @Data class Cidade implements EntidadeBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String uf;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String estado;

    @OneToMany (mappedBy = "cidadeOrigem")
    private Set<Frete> fretesOrigem = new HashSet<>();

    @OneToMany (mappedBy = "cidadeDestino")
    private Set<Frete> fretesDestino = new HashSet<>();

    @OneToMany(mappedBy = "cidadeOrigem")
    private Set<Distancia> distanciasDeOrigem = new HashSet<>();

    @OneToMany(mappedBy = "cidadeDestino")
    private Set<Distancia> distanciasDeDestino = new HashSet<>();


    @Data @NoArgsConstructor @AllArgsConstructor
    public static class CidadeId implements Serializable {
        private String uf;
        private String nome;
    }
}
