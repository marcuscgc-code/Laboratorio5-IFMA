package org.main.entity;

import lombok.*;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
@Table(name = "filial")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Filial implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column
    private String endereco;

    @Column(length = 15, nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "filial")
    private Set<Funcionario> funcionarios = new HashSet<>();

    @OneToMany(mappedBy = "filial")

    @Override
    public Integer getId() {
        return nome != null ? nome.hashCode() : null;
    }
}
