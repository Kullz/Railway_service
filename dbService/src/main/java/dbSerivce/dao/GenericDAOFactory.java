package dbSerivce.dao;


import dbService.model.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.Date;

public class GenericDAOFactory<T> {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("DB_SERVICE");
    private EntityManager em = emf.createEntityManager();

    public GenericDAO<T> createGenericDAO() {
        return new GenericDAOIml<T>(em);
    }

    public static void main(String[] args) {
        GenericDAO<Passenger> p = new GenericDAOFactory<Passenger>().createGenericDAO();
        Passenger pas = new Passenger("T", "TAKA", new Date());
        pas.setId(3);
        p.delete(pas);

    }
}
