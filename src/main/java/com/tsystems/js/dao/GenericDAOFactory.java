package com.tsystems.js.dao;

import com.tsystems.js.models.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAOFactory<T extends HasID> {

    protected static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("DB_SERVICE");
    private EntityManager em = emf.createEntityManager();

    public GenericDAOIml<T> createGenericDAO() {
        return new GenericDAOIml<T>(em);
    }


}
