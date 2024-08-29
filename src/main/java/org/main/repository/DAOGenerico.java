package org.main.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.main.entity.EntidadeBase;

import java.util.List;
import java.util.Objects;

public class DAOGenerico<T extends EntidadeBase> {

    private final EntityManager manager;

    // Construtor que recebe EntityManager
    public DAOGenerico(EntityManager manager) {
        this.manager = manager;
    }

    public EntityManager getManager() {
        return manager;
    }

    // Busca entidade pelo seu Id
    public T buscaPorId(Class<T> clazz, Integer id) {
        return manager.find(clazz, id);
    }

    // Salva ou atualiza uma entidade
    public T salvaOuAtualiza(T t) {
        // Inicia uma transação
        manager.getTransaction().begin();
        try {
            if (Objects.isNull(t.getId())) {
                // Se a entidade não tem ID, é uma nova entidade (inserção)
                manager.persist(t);
            } else {
                // Se a entidade tem ID, é uma entidade existente (atualização)
                t = manager.merge(t);
            }
            // Confirma as alterações na transação
            manager.getTransaction().commit();
        } catch (Exception e) {
            // Reverte as alterações em caso de erro
            manager.getTransaction().rollback();
            throw e; // Lança a exceção para ser tratada em outro lugar
        }
        return t;
    }

    public void remove(T t) {
        manager.remove(t);
        manager.flush();
    }

    // Executa uma consulta JPQL com parâmetros
    public List<T> consultar(String jpql, Class<T> clazz, Object... params) {
        TypedQuery<T> query = manager.createQuery(jpql, clazz);
        // Define os parâmetros da consulta
        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }

        // Retorna a lista de resultados
        return query.getResultList();
    }
}
