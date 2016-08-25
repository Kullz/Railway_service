package clienService;

import dbService.model.Station;
import dbService.model.Train;

import java.util.Date;

/**
 * Created by kull on 25.08.16.
 */
public interface IClientFunctionality {

    Train findTrainTo(String from, String to, Date loTimeBorder, Date hiTimeBorder);

    Station getTimeTable(String station);

    boolean isTicketBuyable(Train trainToTravel);
}
