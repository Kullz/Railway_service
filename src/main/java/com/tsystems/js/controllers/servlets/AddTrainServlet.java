package com.tsystems.js.controllers.servlets;

import com.tsystems.js.services.TrainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kull on 30.08.16.
 */

public class AddTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
    /*
    Processes the request, gets data for creating a train (number, stations, arrival time)
    * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long trainNumber = Long.parseLong(request.getParameter("train"));
        Map<Time, String> timeTable = new HashMap<>();

        String[] time = request.getParameterValues("time");
        String[] stations = request.getParameterValues("station");

        DateFormat formatter = new SimpleDateFormat("HH:mm");

        for(int i = 0; i < stations.length; i++){
            try {
                Time arrTime = new Time(formatter.parse(time[i]).getTime());
                timeTable.put(arrTime, stations[i]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        TrainService.addTrainToDatabase(trainNumber, timeTable);
    }
}
