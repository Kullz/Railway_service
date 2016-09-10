package com.tsystems.js.services;


import com.tsystems.js.dao.GenericDAO;
import com.tsystems.js.dao.GenericDAOIml;
import com.tsystems.js.models.Passenger;
import com.tsystems.js.models.Ticket;
import com.tsystems.js.models.Train;
import com.tsystems.js.utils.Util;

import java.util.Date;

public class BuyTicket {

    private static GenericDAO<Train> trainDao = new GenericDAOIml<>();
    private static GenericDAO<Ticket> ticketDAO = new GenericDAOIml<>();

    public static String buyTicket(String trainNumber, String name, String surname, String birth){

        Long trainNum = Long.parseLong(trainNumber);
        Date birthday = Util.getDate(birth);

        Train trainData = trainDao.findOneByQuery("SELECT t FROM Train t WHERE t.trainNumber=\'"+trainNumber+"\'");

        int numberOfSeats = trainData.getNumberOfSeats();

        if(numberOfSeats > 0){

            numberOfSeats--;
            trainData.setNumberOfSeats(numberOfSeats);
            trainDao.update(trainData);
            Ticket ticket = new Ticket(trainNum, new Passenger(name, surname, birthday));
            ticketDAO.add(ticket);

            return "success";
        }else{
            return "sold out";
        }
    }

}
