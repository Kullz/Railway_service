package dbSerivce.dao;


import dbService.model.Passenger;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

public class GenericDAOIml<T> implements GenericDAO<T> {

    private T typeId;
    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("DB_SERVICE");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public T add(T entity) {
        tx.begin();
        em.persist(entity);
        tx.commit();
        return entity;
    }

    public void merge(T entity) {
        tx.begin();
        em.merge(entity);
        tx.commit();
    }

    public void delete(T entity) {
        tx.begin();
        em.remove(entity);
        tx.commit();
    }

    public List<T> findManyByType(String query) {
        return findManyByType(query, typeId.getClass());
    }

    private List<T> findManyByType(String query, Class cl){
        return em.createQuery(query, cl).getResultList();
    }

    public T findOneByType(String query){
        return findOneByType(query, typeId.getClass());
    }

    private T findOneByType(String query, Class cl){
        return (T) em.createQuery(query, cl).getSingleResult();
    }

    public T findById(long id){
        return (T) em.find(typeId.getClass(), id);
    }

}
