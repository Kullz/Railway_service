package com.tsystems.js.controllers.servlets;

import com.google.gson.Gson;
import com.tsystems.js.services.PassengerService;
import com.tsystems.js.services.StationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kull on 30.08.16.
 */

public class ShowRegisteredPassengersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(Long.parseLong(request.getParameter("train")));
        Map<String, Object> passengersContainer = new HashMap<>();

        passengersContainer.put("passengers", PassengerService.showRegisteredPassengers(Long.parseLong(request.getParameter("train"))));

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(passengersContainer));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
