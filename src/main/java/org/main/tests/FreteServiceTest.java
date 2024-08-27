package org.main.tests;

import org.main.entity.Frete;
import org.main.entity.Cliente;
import org.main.entity.Distancia;
import org.main.entity.CategoriaFrete;
import org.main.repository.DAOGenerico;
import org.main.service.FreteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class FreteServiceTest {
    private FreteService freteService;
    private DAOGenerico<Frete> freteDAO;
    private DAOGenerico<Cliente> clienteDAO;
    private DAOGenerico<Distancia> distanciaDAO;
    private DAOGenerico<CategoriaFrete> categoriaFreteDAO;
    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        entityManager = mock(EntityManager.class);
        freteDAO = mock(DAOGenerico.class);
        clienteDAO = mock(DAOGenerico.class);
        distanciaDAO = mock(DAOGenerico.class);
        categoriaFreteDAO = mock(DAOGenerico.class);
        freteService = new FreteService(entityManager);
    }

    @Test
    public void testRegistrarNovoFrete() {
        Frete frete = new Frete();
        freteService.registrarNovoFrete(frete);

        verify(freteDAO).salvaOuAtualiza(frete);
    }

    @Test
    public void testBuscarFretePorId() {
        Frete frete = new Frete();
        when(freteDAO.buscaPorId(Frete.class, 1)).thenReturn(frete);

        Frete result = freteService.buscarFretePorId(1);

        assertNotNull(result);
        assertEquals(frete, result);
        verify(freteDAO).buscaPorId(Frete.class, 1);
    }

    @Test
    public void testListarFretesPorCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf("12345678901");
        when(clienteDAO.buscaPorId(Cliente.class, 1)).thenReturn(cliente);

        TypedQuery<Frete> query = mock(TypedQuery.class);
        when(query.getResultList()).thenReturn(List.of(new Frete()));
        when(entityManager.createQuery(anyString(), eq(Frete.class))).thenReturn(query);

        List<Frete> fretes = freteService.listarFretesPorCliente(1);

        assertNotNull(fretes);
        assertFalse(fretes.isEmpty());
        verify(clienteDAO).buscaPorId(Cliente.class, 1);
        verify(query).getResultList();
    }

    @Test
    public void testCalcularValorFrete() {
        Frete frete = new Frete();
        frete.setValorKmRodado(10.0f);

        Distancia distancia = new Distancia();
        distancia.setQuilometros(100);

        when(distanciaDAO.getManager()).thenReturn(entityManager);

        TypedQuery<Distancia> query = mock(TypedQuery.class);
        when(query.getResultList()).thenReturn(List.of(distancia));
        when(entityManager.createQuery(anyString(), eq(Distancia.class))).thenReturn(query);

        CategoriaFrete categoriaFrete = new CategoriaFrete();
        categoriaFrete.setPercentualAdicional(20.0f);
        when(categoriaFreteDAO.buscaPorId(CategoriaFrete.class, anyInt())).thenReturn(categoriaFrete);

        freteService.registrarNovoFrete(frete);

        assertEquals(1200.0f, frete.getValorTotal(), 0.01);
    }
}
