package com.tsystems.js.services;


import com.tsystems.js.dao.GenericDAO;
import com.tsystems.js.dao.GenericDAOIml;
import com.tsystems.js.models.Station;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class StationService {

    private static GenericDAO<Station> stationDAO = new GenericDAOIml<Station>();

    public static List<Station> getAllStations(){
        return stationDAO.findManyByQuery("SELECT station from Station station");
    }

    public static List<String> getStationsNames(){
        return stationDAO.findManyByQuery("SELECT station.station from Station station");
    }

    public static void addStationToDB(String name, Map<Long, Time> timeTable){
        stationDAO.add(new Station(name, timeTable));
    }

}
