package com.tsystems.js.controllers.servlets;

import com.tsystems.js.services.BuyTicket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BuyTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String trainNumber = (String)request.getParameter("trainNumber");
        String name = (String) request.getParameter("name");
        String surname = (String) request.getParameter("surname");
        String birth = (String) request.getParameter("birth_date");

        BuyTicket.buyTicket(trainNumber, name, surname, birth);
        response.sendRedirect("/search_result.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
