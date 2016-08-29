package com.tsystems.js.services;


import com.tsystems.js.dao.GenericDAO;
import com.tsystems.js.dao.GenericDAOIml;
import com.tsystems.js.models.Station;

import java.util.List;

public class StationService {

    private static GenericDAO<Station> stationDAO = new GenericDAOIml<Station>();

    public static List<Station> getAllStations(){
        return stationDAO.findManyByQuery("SELECT station from Station station");
    }

    public static List<String> getStationsNames(){
        return stationDAO.findManyByQuery("SELECT station.station from Station station");
    }

}
