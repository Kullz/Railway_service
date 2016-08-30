package com.tsystems.js.controllers.servlets;

import com.tsystems.js.services.StationService;
import com.tsystems.js.services.TrainService;
import com.tsystems.js.utils.Util;

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
public class AddStationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stationName = request.getParameter("station");
        Map<Long, Time> timeTable = new HashMap<>();

        String[] time = request.getParameterValues("time");
        String[] trains = request.getParameterValues("train");

        PrintWriter out = response.getWriter();

        for (int i = 0; i < trains.length; i++) {

            Time arrTime = Util.getTime(time[i]);
            Long trainNumber = Long.parseLong(trains[i]);
            timeTable.put(trainNumber, arrTime);
        }

        out.print(timeTable);
        out.print(stationName);



        StationService.addStationToDB(stationName, timeTable);
    }
}
