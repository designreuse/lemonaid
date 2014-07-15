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

        req.setAttribute("placeholder", "This is a placeholder!");
        getServletContext().getRequestDispatcher("/Placeholder.jsp").forward(req, resp);
    }

}
