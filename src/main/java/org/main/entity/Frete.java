package org.main.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Frete implements EntidadeBase {

    @EqualsAndHashCode.Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private Integer numeroNotaFiscal;

    private Float valorKmRodado;
    private String cidadeOrigemUf;
    private String cidadeDestinoUf;
    private String cidadeDestinoNome;
    private Integer categoriaFreteId;
    private String cidadeOrigemNome;
    private float valorTotal;

    @ManyToOne
    @JoinColumn(name = "tipoVeiculoId")
    private TipoVeiculo tipoVeiculo;

    @ManyToOne
    @JoinColumn(name = "categoriaFreteId")
    private CategoriaFrete categoriaFrete;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "cidadeOrigemUf", referencedColumnName = "uf"),
            @JoinColumn(name = "cidadeOrigemNome", referencedColumnName = "nome")
    })
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "cidadeDestinoUf", referencedColumnName = "uf"),
            @JoinColumn(name = "cidadeDestinoNome", referencedColumnName = "nome")
    })
    private Cidade cidadeDestino;

    @Override
    public Integer getId() {
        return codigo;
    }

    public String getCidadeOrigemUf() {
        return cidadeOrigemUf;
    }


    public void setCidadeOrigemUf(String cidadeOrigemUf) {
        this.cidadeOrigemUf = cidadeOrigemUf;
    }

    public String getCidadeDestinoUf() {
        return cidadeDestinoUf;
    }

    public void setCidadeDestinoUf(String cidadeDestinoUf) {
        this.cidadeDestinoUf = cidadeDestinoUf;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getCategoriaFreteId() {
        return categoriaFreteId;
    }

    public void setCategoriaFreteId(Integer categoriaFreteId) {
        this.categoriaFreteId = categoriaFreteId;
    }

    public String getCidadeDestinoNome() {
        return cidadeDestinoNome;
    }

    public void setCidadeDestinoNome(String cidadeDestinoNome) {
        this.cidadeDestinoNome = cidadeDestinoNome;
    }

    public String getCidadeOrigemNome() {
        return cidadeOrigemNome;
    }

    public void setCidadeOrigemNome(String cidadeOrigemNome) {
        this.cidadeOrigemNome = cidadeOrigemNome;
    }
}
