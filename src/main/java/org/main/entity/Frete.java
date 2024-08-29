package org.main.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jakarta.persistence.*;


@NoArgsConstructor @AllArgsConstructor
@Table (name = "frete")
@Entity
public @Data class Frete implements EntidadeBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @ManyToOne @JoinColumn (name = "id_categoria_frete")
    private CategoriaFrete categoriaFrete;

    @ManyToOne @JoinColumn (name = "id_cidade_origem")
    private Cidade cidadeOrigem;

    @ManyToOne @JoinColumn (name = "id_cidade_destino")
    private Cidade cidadeDestino;

    @ManyToOne @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @ManyToOne @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "numero_nota_fiscal")
    private Integer numeroNotaFiscal;

    @Column (name = "valor_km_rodado")
    private BigDecimal valorKmRodado;

    @Override
    public Integer getId() {
        return this.codigo;

    }

    public BigDecimal calcularFrete() {
        Integer distancia = buscaDistancia(this.getCidadeOrigem(), this.getCidadeDestino());


        //Caso distancia seja igual a zero ou nuro, retornar zero absouluto
        if (distancia == null) {
            return BigDecimal.ZERO;
        }


        //Fazendo o calculo percentual de frete
        float percentualAdicional = this.getCategoriaFrete().getPercentualAdicional();

        // Calculando o valor original do frete
        BigDecimal valorKmRodado = this.getValorKmRodado();
        BigDecimal valorOriginal = BigDecimal.valueOf(distancia).multiply(valorKmRodado);

        // ACrescimo do valor sendo inserido
        BigDecimal percentual = BigDecimal.valueOf(percentualAdicional).divide(BigDecimal.valueOf(100));
        BigDecimal valorAcrecimo = valorOriginal.multiply(percentual);

        // Retornando valor mais acréscimo
        return valorOriginal.add(valorAcrecimo);
    }

    private Integer buscaDistancia(Cidade origem, Cidade destino) {
        // Navega pelas distâncias de origem e procura a distância para o destino
        for (Distancia distancia : origem.getDistanciasDeOrigem()) {
            if (distancia.getCidadeDestino().equals(destino)) {
                // Mostra a distancia em Quilometros
                return distancia.getQuilometros();
            }
        }


        return null;
    }

}
