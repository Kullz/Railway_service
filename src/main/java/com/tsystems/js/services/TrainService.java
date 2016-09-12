package com.tsystems.js.services;

import com.tsystems.js.dao.GenericDAO;
import com.tsystems.js.dao.GenericDAOIml;
import com.tsystems.js.models.Station;
import com.tsystems.js.models.Train;
import com.tsystems.js.utils.Util;
import sun.net.www.content.text.Generic;

import java.sql.Time;
import java.util.*;

/**
 * Created by kull on 28.08.16.
 */
public class TrainService {

    private static GenericDAO<Train> trainDAO = new GenericDAOIml<Train>();
    private static GenericDAO<Station> stationDAO = new GenericDAOIml<Station>();

    public static List<Train> getAllTrains(){
        return new GenericDAOIml<Train>().findManyByQuery("SELECT train from Train train");
    }

    /*
    This method gets all train numbers available in database, returns a list of longs if
    not empty otherwise null
    */
    public static List<Long> getAllTrainsNumbers(){

        List<Long> trainNumber = trainDAO.findManyByQuery("SELECT t.trainNumber FROM Train t");
        if(trainNumber.size() == 0){
            return null;
        }else {
            return trainNumber;
        }
    }

    /*
    This method adds train to database based on info from the AddTrainForm.jsp
    As only existing stations are used retrieving reference on existing station inside
    database with id to avoid duplicates inside Station table
    * */
    public static void addTrainToDatabase(long trainNumber, Map<String, Time> timeTable, int numberOfSeats){

        Train toInsert = new Train(trainNumber, numberOfSeats);

        Set<Station> stationsToInsert = new HashSet<>();

        for(Map.Entry<String, Time> timeUnit : timeTable.entrySet()){
            //Retrieving existing station from Station table
            Station station = ((GenericDAOIml<Station>)stationDAO).isInDatabase(new Station(timeUnit.getKey()));

            stationsToInsert.add(station);
            //Modifying station's timetable
            station.getTimeTable().put(trainNumber, timeUnit.getValue());
            stationDAO.update(station);
        }

        toInsert.setStations(stationsToInsert);
        trainDAO.add(toInsert);
    }

    public static List<Train> searchExactTrains(String from, String to, String fromTime, String toTime ){

        Station start = stationDAO.findOneByQuery("SELECT st FROM Station st WHERE st.station=" + "'"+from+"'");
        Station finish = stationDAO.findOneByQuery("SELECT st FROM Station st WHERE st.station=" + "'"+ to + "'");

        List<Train> out = new ArrayList<Train>();
        Map<Long, Time> stA = start.getTimeTable();
        Map<Long, Time> stB = finish.getTimeTable();


        for(Map.Entry<Long, Time> pair: stA.entrySet()){

            Long trMatch = pair.getKey();

            if(stB.containsKey(trMatch) && stA.get(trMatch).getTime() > Util.getTime(fromTime).getTime() && stB.get(trMatch).getTime() < Util.getTime(toTime).getTime()){
                out.add((Train) trainDAO.findOneByQuery("SELECT tr FROM Train tr WHERE tr.trainNumber="+"'"+trMatch + "'"));
            }
        }
        return out;
    }

    public static void deleteTrain(int id){
        trainDAO.remove(new Train(id));
    }

    public static void updateTrain(int trainNumber, int seats) {
        trainDAO.update(new Train(trainNumber, seats));
    }
}
