package org.main.service;

import org.main.entity.CategoriaFrete;
import org.main.entity.Cliente;
import org.main.entity.Distancia;
import org.main.entity.Frete;
import org.main.entity.Frete.*;
import org.main.repository.DAOGenerico;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class FreteService {
    private final DAOGenerico<Frete> freteDAO;
    private final DAOGenerico<Cliente> clienteDAO;
    private final DAOGenerico<Distancia> distanciaDAO;
    private final DAOGenerico<CategoriaFrete> categoriaFreteDAO;

    public FreteService(EntityManager entityManager) {
        this.freteDAO = new DAOGenerico<>(entityManager);
        this.clienteDAO = new DAOGenerico<>(entityManager);
        this.distanciaDAO = new DAOGenerico<>(entityManager);
        this.categoriaFreteDAO = new DAOGenerico<>(entityManager);
    }
    public Frete registrarNovoFrete(Frete frete) {
        // Calcular o valor do frete antes de salvar
        calcularValorFrete(frete);
        return freteDAO.salvaOuAtualiza(frete);
    }

    public Frete buscarFretePorId(Integer id) {
        return freteDAO.buscaPorId(Frete.class, id);
    }

    public List<Frete> listarFretesPorCliente(Integer clienteId) {
        Cliente cliente = clienteDAO.buscaPorId(Cliente.class, clienteId);
        if (cliente != null) {
            // Lógica para buscar fretes pelo cliente
            return freteDAO.getManager()
                    .createQuery("SELECT f FROM Frete f WHERE f.cliente.cpf = :cpf", Frete.class)
                    .setParameter("cpf", cliente.getCpf())
                    .getResultList();
        }
        return List.of();
    }

    private void calcularValorFrete(Frete frete) {
        // Recuperar a distância entre as cidades de origem e destino
        Optional<Distancia> distancia = distanciaDAO.getManager()
                .createQuery("SELECT d FROM Distancia d WHERE d.origemUf = :origemUf AND d.origemNome = :origemNome AND d.destinoUf = :destinoUf AND d.destinoNome = :destinoNome", Distancia.class)
                .setParameter("origemUf", frete.getCidadeOrigemUf())
                .setParameter("origemNome", frete.getCidadeOrigemNome())
                .setParameter("destinoUf", frete.getCidadeDestinoUf())
                .setParameter("destinoNome", frete.getCidadeDestinoNome())
                .getResultList().stream().findFirst();

        if (distancia.isPresent()) {
            // Recuperar o percentual adicional da categoria de frete
            CategoriaFrete categoriaFrete = categoriaFreteDAO.buscaPorId(CategoriaFrete.class, frete.getCategoriaFreteId());
            float valorTotal = distancia.get().getQuilometros() * frete.getValorKmRodado();
            valorTotal += valorTotal * (categoriaFrete.getPercentualAdicional() / 100);

            frete.setValorTotal(valorTotal);
        } else {
            throw new IllegalArgumentException("Distância não encontrada entre as cidades especificadas.");
        }
    }

}
