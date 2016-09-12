package com.tsystems.js.controllers.servlets;

import com.tsystems.js.services.TrainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kull on 11.09.16.
 */
public class UpdateTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int trainNumber = Integer.parseInt(request.getParameter("train"));
        int seats = Integer.parseInt(request.getParameter("numberSeats"));
        TrainService.updateTrain(trainNumber, seats);
    }
}
