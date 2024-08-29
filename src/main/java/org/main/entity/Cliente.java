package org.main.entity;

import lombok.*;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name= "cliente")
public @Data class Cliente extends PessoaFisica {

    @Column
    private String contato;

    @Column
    private Boolean ativo;

    @OneToMany(mappedBy = "cliente")
    private Set<Frete> fretes = new HashSet<>();


}
