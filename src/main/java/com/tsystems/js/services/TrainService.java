package com.tsystems.js.services;

import com.tsystems.js.dao.GenericDAO;
import com.tsystems.js.dao.GenericDAOIml;
import com.tsystems.js.models.Station;
import com.tsystems.js.models.Train;
import sun.net.www.content.text.Generic;

import java.sql.Time;
import java.util.*;

/**
 * Created by kull on 28.08.16.
 */
public class TrainService {

    private static GenericDAO<Train> trainDAO = new GenericDAOIml<Train>();
    private static GenericDAO<Station> stationDAO = new GenericDAOIml<Station>();

    public static Train getExactTrain(Station from, Station to, Date lowInterval, Date highInterval){
        GenericDAO<Train> daoTrain = new GenericDAOIml<Train>();
        daoTrain.findManyByQuery(
          "SELECT train FROM Train train WHERE train."
        );
        return null;
    }

    public static List<Train> getAllTrains(){
        return new GenericDAOIml<Train>().findManyByQuery("SELECT train from Train train");
    }

    /*
    This method adds train to database based on info from the AddTrainForm.jsp
    As only existing stations are used retrieving reference on existing station inside
    database with id to avoid duplicates inside Station table
    * */
    public static void addTrainToDatabase(long trainNumber, Map<Time, String> timeTable){

        Train toInsert = new Train(trainNumber);
        Set<Station> stationsToInsert = new HashSet<>();

        for(Map.Entry<Time, String> timeUnit : timeTable.entrySet()){
            //Retrieving existing station from Station table
            Station station = ((GenericDAOIml<Station>)stationDAO).isInDatabase(new Station(timeUnit.getValue()));

            stationsToInsert.add(station);
            //Modifying station's timetable
            station.getTimeTable().put(timeUnit.getKey(), trainNumber);
            stationDAO.update(station);
        }

        toInsert.setStations(stationsToInsert);
        trainDAO.add(toInsert);
    }

}
