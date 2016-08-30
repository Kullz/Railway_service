package com.tsystems.js.services;


import com.tsystems.js.dao.GenericDAOIml;
import com.tsystems.js.models.Passenger;
import com.tsystems.js.models.Ticket;

import java.sql.Date;
import java.util.List;

public class PassengerService {

    private static GenericDAOIml<Passenger> passengerDAO = new GenericDAOIml<>();
    private static GenericDAOIml<Ticket> ticketDAO = new GenericDAOIml<>();

    public static List<Passenger> getAllPassengers(){
        return new GenericDAOIml<Passenger>().findManyByQuery("SELECT p FROM Passenger p");
    }


    public static List<Passenger> showRegisteredPassengers(Long trainNumber){
        return ticketDAO.findManyByQuery("SELECT ticket.passenger FROM Ticket ticket WHERE ticket.trainNumber=" + "'" + trainNumber + "'");
    }

}
