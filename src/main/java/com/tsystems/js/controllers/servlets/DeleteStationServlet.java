package com.tsystems.js.controllers.servlets;

import com.tsystems.js.services.StationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kull on 12.09.16.
 */
public class DeleteStationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int st_id = Integer.parseInt(request.getParameter("id"));
        StationService.deleteStation(st_id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
