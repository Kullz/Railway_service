package com.tsystems.js.dao;

import com.tsystems.js.models.Passenger;
import com.tsystems.js.models.Station;
import com.tsystems.js.models.Ticket;
import com.tsystems.js.models.Train;

import javax.persistence.*;
import java.util.*;

/**
 * Basic DAO class. Provides basic CRUD operations defined in GenericDAO interface
 * applied to MySQL database using JPA and Hibernate
 * @author Kirill Ulianichev
 *
 * @version 1.0.0
 *
 * @param <T> Parameter that refers to predefined entities (Passenger, Station, Ticket, Train)
 */

public class GenericDAOIml<T extends HasID> implements GenericDAO<T>{

    protected static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("DB_SERVICE");

    private EntityManager em;

    public GenericDAOIml() {
        this.em = emf.createEntityManager();

    }

    /*
    Basic CRUD methods
     */

    public  void    add   (T entity) {

        EntityTransaction tx = em.getTransaction();
        try {
            isInDatabase(entity);
        }catch (Exception e){
            tx.begin();
            em.persist(em.merge(entity));
            tx.commit();
        }
    }

    public  void    update(T entity) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.merge(isInDatabase(entity)));
            em.persist(entity);
            tx.commit();
        }catch (Exception e) {

        }
    }

    public  void    remove(T entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            entity = (T) em.find(entity.getClass(), entity.getId());
            em.remove(entity);
            em.flush();
            tx.commit();
        }catch (Exception e){}
    }



    public  <K> List<K> findManyByQuery(String query) {
        return (List<K>) em.createQuery(query).getResultList();
    }

    public  T       findOneByQuery (String query){
        return (T)em.createQuery(query).getSingleResult();
    }

    /*
    As only generated Id used as primary key for all entities to avoid duplicates
    is written isInDatabase method that searches for equal record inside database,
    if there is a match returns given entity, otherwise null
     */
    public T       isInDatabase   (T entity) {
        String specificType = entity.getClass().getSimpleName();
        switch (specificType){
            case "Passenger":
                return (T)em.createNamedQuery(Passenger.FIND)
                        .setParameter("name",    ((Passenger)entity).getPassengerName())
                        .setParameter("surname", ((Passenger)entity).getPassengerSurname())
                        .setParameter("date",    ((Passenger)entity).getDateOfBirth())
                        .getSingleResult();

            case "Station":
                return (T)em.createNamedQuery(Station.FIND)
                        .setParameter("station", ((Station)entity).getStation())
                        .getSingleResult();

            case "Train":
                return (T)em.createNamedQuery(Train.FIND)
                        .setParameter("trainNumber", ((Train)entity).getTrainNumber())
                        .getSingleResult();

            case "Ticket":
                return (T)em.createNamedQuery(Ticket.FIND)
                        .setParameter("trainNumber", ((Ticket)entity).getTrainNumber())
                        .setParameter("name",        ((Ticket)entity).getPassenger().getPassengerName())
                        .setParameter("surname",     ((Ticket)entity).getPassenger().getPassengerSurname())
                        .setParameter("date",        ((Ticket)entity).getPassenger().getDateOfBirth())
                        .getSingleResult();

            default: break;
        }

        return null;
    }

    public static EntityManager neverUsethis(){
        return emf.createEntityManager();
    }

//    public static void main(String[] args) {
//        Station st1 = new Station("Success", new HashMap<Date, Long>());
//        Station st2 = new Station("Failure", new HashMap<Date, Long>());
//        st2.getTimeTable().put(new Date(), 4444l);
//        st1.getTimeTable().put(new Date(), 4444l);
//
//        Train train = new Train(4444l, new HashSet<Station>(), 30);
//
//        GenericDAO<Train> daoTrain = new GenericDAOIml<Train>();
//
//        daoTrain.add(train);
//    }


}
