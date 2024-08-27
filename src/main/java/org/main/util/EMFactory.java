package org.main.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class EMFactory {
    private static final EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("carrofrete");


    public EntityManager getEntityManager() {
        return factory.createEntityManager();

    }

    public void close() {
        factory.close();
    }
}
