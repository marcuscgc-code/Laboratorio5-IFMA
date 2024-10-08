package org.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor @AllArgsConstructor
@Data
@Entity (name = "funcionario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcionario extends PessoaFisica {

    @Column(length = 20, nullable = false)
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;



}
