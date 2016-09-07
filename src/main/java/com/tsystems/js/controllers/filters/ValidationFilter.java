package com.tsystems.js.controllers.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by kull on 03.09.16.
 */
/* Filter for validation user input inside add_train and add_station forms*/
public class ValidationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // Loking for form type which is given inside hidden field named "type"
        switch(req.getParameter("type")){
            case "addtrain":

        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
