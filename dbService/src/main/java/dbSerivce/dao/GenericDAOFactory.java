package dbSerivce.dao;

import dbService.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class GenericDAOFactory<T extends HasID> {

    protected static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("DB_SERVICE");
    private EntityManager em = emf.createEntityManager();

    public GenericDAOIml<T> createGenericDAO() {
        return new GenericDAOIml<T>(em);
    }

    public static void main(String[] args) {
    }
}
