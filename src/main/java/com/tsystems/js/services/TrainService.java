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
    public static void addTrainToDatabase(long trainNumber, Map<String, Time> timeTable){

        Train toInsert = new Train(trainNumber);
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

    public static List<Train> searchExactTrains(Station from, Station to, Time fromTime, Time toTime ){
        Station start = stationDAO.findOneByQuery("SELECT st FROM Station st WHERE st.station=" + "'"+from.getStation()+"'");
        Station finish = stationDAO.findOneByQuery("SELECT st FROM Station st WHERE st.station=" + "'"+to.getStation()+ "'");

        List<Train> out = new ArrayList<>();
        Map<Long, Time> stA = start.getTimeTable();
        Map<Long, Time> stB = finish.getTimeTable();


        for(Map.Entry<Long, Time> pair: stA.entrySet()){

            Long trMatch = pair.getKey();

            if(stB.containsKey(trMatch) && stA.get(trMatch).getTime() > fromTime.getTime() && stB.get(trMatch).getTime() < toTime.getTime()){
                out.add((Train) trainDAO.findOneByQuery("SELECT tr FROM Train tr WHERE tr.trainNumber="+"'"+trMatch + "'"));
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(searchExactTrains(new Station("sad"), new Station("bad"), new Time(9, 30,00), new Time(12, 40, 00)));
    }

}
