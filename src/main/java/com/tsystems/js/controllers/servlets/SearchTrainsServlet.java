package com.tsystems.js.controllers.servlets;

import com.tsystems.js.models.Station;
import com.tsystems.js.models.Train;
import com.tsystems.js.services.TrainService;
import com.tsystems.js.utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by kull on 01.09.16.
 */
@WebServlet(name = "SearchTrainsServlet")
public class SearchTrainsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/searchTrains.jsp");

    }


}
