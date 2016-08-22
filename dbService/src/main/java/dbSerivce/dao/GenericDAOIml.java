package dbSerivce.dao;


import dbService.model.Passenger;
import dbService.model.Station;
import dbService.model.Ticket;
import dbService.model.Train;

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
        tx.begin();
        em.persist(isInDatabase(entity));
        tx.commit();
        return entity;
    }

    public void merge(T entity) {
        tx.begin();
        em.merge(isInDatabase(entity));
        tx.commit();
    }

    public void delete(T entity) {
        tx.begin();
        em.remove(isInDatabase(entity));
        tx.commit();
    }

    public  List<T> findManyByType(String query) {
        return findManyByType(query, typeId.getClass());
    }

    private List<T> findManyByType(String query, Class cl){
        return em.createQuery(query, cl).getResultList();
    }

    public  T findOneByType(String query){
        return findOneByType(query, typeId.getClass());
    }

    private T findOneByType(String query, Class cl){
        return (T) em.createQuery(query, cl).getSingleResult();
    }

    public  T findById(long id){
        return (T) em.find(typeId.getClass(), id);
    }

    private T isInDatabase(T entity) {
        String specificType = typeId.getClass().getSimpleName();
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
                break;

            case "Station":
                return (T)em.createQuery
                        ("SELECT s FROM Station s "+"WHERE s.station=:station")
                        .setParameter("station", ((Station)entity).getStation())
                        .getSingleResult();
                break;

            case "Train":
                return (T)em.createQuery
                        ("SELECT t FROM Train t "+"WHERE t.trainNumber=:trainNumber")
                        .setParameter("trainNumber", ((Train)entity).getTrainNumber())
                        .getSingleResult();
            break;

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
            break;

            default: break;
        }
    }



}
