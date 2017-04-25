package com.tramasoli.telegram.qatorbot.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by fabio on 24/04/17.
 */
public class DAO {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-sqlite-jpa");

    static public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
