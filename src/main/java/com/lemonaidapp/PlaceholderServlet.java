package com.lemonaidapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ddcdanter on 7/12/14.
 */

public class PlaceholderServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // find some way to do the business logic here
        // ...
        SumMultiplesOf3And5 number = new SumMultiplesOf3And5();

        // put the required output in the request attributes to share with the jsp
        req.setAttribute("placeholder", number);
        getServletContext().getRequestDispatcher("/Placeholder.jsp").forward(req, resp);
    }

}
