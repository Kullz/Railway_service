package dbSerivce.dao;


import dbService.model.Passenger;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

public class GenericDAOIml<T> implements GenericDAO<T> {

    private T typeId;
    private EntityManager em;
    private EntityTransaction tx;

    public GenericDAOIml(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }

    public T add(T entity) {
        em.createQuery(
                "SELECT c FROM Customer c WHERE c.name LIKE :custName")
                .setParameter("custName", name)
                .setMaxResults(10)
                .getResultList();
        "SELECT t FROM T "
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT t FROM ").append(Passenger.class.getSimpleName()).append(" t")
        tx.begin();
        T innerEntity = findOneByType( +  + "")
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
        em.remove(em.merge(entity));
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

    "SELECT c FROM Customer c WHERE c.name LIKE :custName"
    private T isExists(){
        String specificType = typeId.getClass().getSimpleName();
        switch (specificType){
            case "Passenger":
                return em.createQuery("SELECT c FROM Customer c WHERE c.name LIKE :custName").setPa;
                break;
            case "Station":
                return "SELECT c FROM Customer c WHERE c.name LIKE :custName";
            default: break;
        }
    }



}
