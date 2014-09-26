package com.lemonaidapp.maintenance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ddcdanter on 9/26/14.
 */
public class MaintenanceHomeController extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

        getServletContext().getRequestDispatcher("/maintenance/home.jsp").forward(req, resp);
    }
}
