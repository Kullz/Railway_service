package dbSerivce.dao;


import dbService.model.Passenger;
import dbService.model.Station;
import dbService.model.Ticket;
import dbService.model.Train;

import javax.persistence.*;
import java.util.List;

public class GenericDAOIml<T> implements GenericDAO<T> {

    private Class typeId;
    private EntityManager em;
    private EntityTransaction tx;

    public GenericDAOIml(EntityManager em) {
        this.em = em;
        this.tx = em.getTransaction();
    }

    public T add(T entity) {
        typeId = entity.getClass();
        T temp;
        try {
            temp = isInDatabase(entity);
        }catch (javax.persistence.NoResultException e){
            tx.begin();
            em.persist(entity);
            tx.commit();
            return entity;
        }
        return temp;
    }

    public void merge(T entity) {
        typeId = entity.getClass();
        T temp = isInDatabase(entity);
        tx.begin();
        em.merge(temp != null ? temp : entity);
        tx.commit();
    }

    public void delete(T entity) {
        typeId = entity.getClass();
        T temp = isInDatabase(entity);
        if(temp != null) {
            tx.begin();
            em.remove(temp);
            tx.commit();
        }
    }

    public  List<T> findManyByQuery(String query) {
        return findManyByQuery(query, typeId.getClass());
    }

    private List<T> findManyByQuery(String query, Class cl){
        return em.createQuery(query, cl).getResultList();
    }

    public  T       findOneByQuery(String query){
        return findOneByQuery(query, typeId.getClass());
    }

    private T       findOneByQuery(String query, Class cl){
        return (T) em.createQuery(query, cl).getSingleResult();
    }

    public  T       findById(long id){
        return (T) em.find(typeId.getClass(), id);
    }

    private T isInDatabase(T entity) {
        String specificType = typeId.getSimpleName();
        switch (specificType){
            case "Passenger":
                return (T)em.createQuery
                        ("SELECT p FROM Passenger p " +
                         "WHERE p.passengerName=:name " +
                         "AND p.passengerSurname=:surname " +
                         "AND p.dateOfBirth=:date")
                        .setParameter("name",    ((Passenger)entity).getPassengerName())
                        .setParameter("surname", ((Passenger)entity).getPassengerSurname())
                        .setParameter("date",    ((Passenger)entity).getDateOfBirth())
                        .getSingleResult();

            case "Station":
                return (T)em.createQuery
                        ("SELECT s FROM Station s "+"WHERE s.station=:station")
                        .setParameter("station", ((Station)entity).getStation())
                        .getSingleResult();

            case "Train":
                return (T)em.createQuery
                        ("SELECT t FROM Train t "+"WHERE t.trainNumber=:trainNumber")
                        .setParameter("trainNumber", ((Train)entity).getTrainNumber())
                        .getSingleResult();

            case "Ticket":
                return (T)em.createQuery
                        ("SELECT t FROM Ticket t " +
                         "WHERE t.trainNumber=:trainNumber " +
                         "AND t.passenger.passengerSurname=:surname " +
                         "AND t.passenger.passengerName=:name " +
                         "AND t.passenger.dateOfBirth=:date")
                        .setParameter("trainNumber", ((Ticket)entity).getTrainNumber())
                        .setParameter("name",        ((Ticket)entity).getPassenger().getPassengerName())
                        .setParameter("surname",     ((Ticket)entity).getPassenger().getPassengerSurname())
                        .setParameter("date",        ((Ticket)entity).getPassenger().getDateOfBirth())
                        .getSingleResult();

            default: break;
        }

        return null;
    }



}
