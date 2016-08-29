package com.tsystems.js.services;


import com.tsystems.js.dao.GenericDAOIml;
import com.tsystems.js.models.Passenger;

import java.util.List;

public class PassengerService {

    public static List<Passenger> getAllPassengers(){
        return new GenericDAOIml<Passenger>().findManyByQuery("SELECT p FROM Passenger p");
    }

    public static void main(String[] args) {
        System.out.println(getAllPassengers());
    }
}
