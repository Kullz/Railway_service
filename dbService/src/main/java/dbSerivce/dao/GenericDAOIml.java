package dbSerivce.dao;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class GenericDAOIml<T> implements GenericDAO<T> {

    private EntityManager em = Persistence.createEntityManagerFactory("DB_SERVICE").createEntityManager();

    public void save(T entity) {

    }

    public void merge(T entity) {

    }

    public void delete(T entity) {

    }

    public List findMany(Query query) {
        return null;
    }

    public T findOne(Query query) {
        return null;
    }

}
