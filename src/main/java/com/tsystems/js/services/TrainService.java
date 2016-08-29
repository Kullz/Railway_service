package com.tsystems.js.services;

import com.tsystems.js.dao.GenericDAO;
import com.tsystems.js.dao.GenericDAOIml;
import com.tsystems.js.models.Station;
import com.tsystems.js.models.Train;

import java.util.Date;
import java.util.List;

/**
 * Created by kull on 28.08.16.
 */
public class TrainService {

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
}
