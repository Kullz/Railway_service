package com.tsystems.js.services;

import com.tsystems.js.dao.GenericDAOFactory;
import com.tsystems.js.models.Station;
import com.tsystems.js.models.Train;

import java.util.List;

/**
 * Created by kull on 28.08.16.
 */
public class TrainService {

    public static List<Train> getAllTrains(){
        return new GenericDAOFactory<Train>().createGenericDAO().findManyByQuery("SELECT train from Train train");
    }
}
