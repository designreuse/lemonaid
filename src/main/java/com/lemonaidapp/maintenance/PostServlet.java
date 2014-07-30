package com.lemonaidapp.maintenance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ddcdanter on 7/30/14.
 */
public class PostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<MaintenanceEvent> events = new ArrayList<MaintenanceEvent>();

        MaintenanceEvent oilChange = new MaintenanceEvent();
        Calendar oilChangeCal = Calendar.getInstance();
        oilChangeCal.set(2014, 4, 15);
        oilChange.setDate(oilChangeCal.getTime());
        oilChange.setTask("Changed Oil");
        oilChange.setComments("4 Quarts Mobil1");
        oilChange.setVehicleName("Subaru Impreza");
        events.add(oilChange);

        MaintenanceEvent brakeWork = new MaintenanceEvent();
        Calendar brakeWorkCal = Calendar.getInstance();
        brakeWorkCal.set(2014, 4, 15);
        brakeWork.setDate(brakeWorkCal.getTime());
        brakeWork.setTask("Changed Brake Pads");
        brakeWork.setComments("Life expectancy: 60,000 miles");
        brakeWork.setVehicleName("Subaru Impreza");
        events.add(brakeWork);

        req.setAttribute("events", events);
        getServletContext().getRequestDispatcher("/maintenance/listing.jsp").forward(req, resp);

    }
}
