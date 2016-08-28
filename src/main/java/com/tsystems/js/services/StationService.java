package com.tsystems.js.services;


import com.tsystems.js.dao.GenericDAO;
import com.tsystems.js.dao.GenericDAOFactory;
import com.tsystems.js.models.Station;

import java.util.List;

public class StationService {
    public static List<Station> getAllStations(){
        return new GenericDAOFactory<Station>().createGenericDAO().findManyByQuery("SELECT station from Station station");
    }
}
