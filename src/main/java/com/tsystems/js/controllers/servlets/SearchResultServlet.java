package com.tsystems.js.controllers.servlets;

import com.tsystems.js.models.Train;
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
import java.util.List;


public class SearchResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String fromSt = request.getParameter("fromSt");
        String toSt = request.getParameter("toSt");
        String fromTime = request.getParameter("fromTime");
        String toTime = request.getParameter("toTime");

        session.setAttribute("fromSt", fromSt);
        session.setAttribute("toSt", toSt);
        session.setAttribute("fromTime", fromTime);
        session.setAttribute("toTime", toTime);


        response.sendRedirect("/search_result.jsp");
    }
}
