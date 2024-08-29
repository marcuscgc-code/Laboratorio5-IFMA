package org.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            // Cria o EntityManagerFactory usando a configuração do persistence.xml
            emf = Persistence.createEntityManagerFactory("carro_frete");
            // Cria o EntityManager
            em = emf.createEntityManager();

            // Testa a conexão executando uma simples consulta
            em.getTransaction().begin();
            System.out.println("Conexão bem-sucedida!");
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Falha na conexão com o banco de dados.");
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
    }
}