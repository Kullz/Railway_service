package com.tsystems.js.services;


import com.tsystems.js.dao.GenericDAOFactory;
import com.tsystems.js.models.Passenger;

import java.util.List;

public class PassengerService {

    public static List<Passenger> getAllPassengers(){
        return new GenericDAOFactory<Passenger>().createGenericDAO().findManyByQuery("SELECT p FROM Passenger p");
    }

    public static void main(String[] args) {
        System.out.println(getAllPassengers());
    }
}
