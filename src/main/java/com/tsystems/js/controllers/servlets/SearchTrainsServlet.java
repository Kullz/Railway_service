package com.tsystems.js.controllers.servlets;

import com.google.gson.Gson;
import com.tsystems.js.models.Station;
import com.tsystems.js.models.Train;
import com.tsystems.js.services.StationService;
import com.tsystems.js.services.TrainService;
import com.tsystems.js.utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SearchTrainsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String fromSt = (String)session.getAttribute("fromSt");
        String toSt = (String)session.getAttribute("toSt");
        String fromTime = (String)session.getAttribute("fromTime");
        String toTime = (String)session.getAttribute("toTime");

        List<Train> result = TrainService.searchExactTrains(fromSt, toSt, fromTime, toTime);

        Map<String, Object> trainsContainer = new HashMap<>();

        trainsContainer.put("trains", result );

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(trainsContainer));

    }


}
