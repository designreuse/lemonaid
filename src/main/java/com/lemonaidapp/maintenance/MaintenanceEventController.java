package com.lemonaidapp.maintenance;

import sun.applet.Main;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaintenanceEventController extends HttpServlet {

	private MaintenanceEventRepo eventRepo;
	
	public MaintenanceEventController() {
		this.eventRepo = MaintenanceEventRepo.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		MaintenanceEvent newEvent = new MaintenanceEvent();
        newEvent.setDate(new Date());
        newEvent.setTask(req.getParameter("task"));
        newEvent.setComments(req.getParameter("comment"));
        newEvent.setMileage(Integer.MAX_VALUE);
        newEvent.setVehicleName(req.getParameter("vehicleName"));
        newEvent.setId(new Random(System.currentTimeMillis()).nextInt(Integer.MAX_VALUE));;
        
        this.eventRepo.createEvent(newEvent);
        
		List<MaintenanceEvent> events = this.eventRepo.findAllEvents();
		
		req.setAttribute("events", events);
        getServletContext().getRequestDispatcher("/maintenance/listing.jsp").forward(req, resp);
	}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        MaintenanceEvent event = new MaintenanceEvent();
        int id = -1;
        
        if (req.getParameter("id") != null) {
        	id = Integer.parseInt(req.getParameter("id"));
            if (id == -1) {
                resp.sendError(500, "Error loading maintenance event");
            }
        }

        event = this.eventRepo.findEventById(id);
        req.setAttribute("event", event);
        getServletContext().getRequestDispatcher("/maintenance/event.jsp").forward(req, resp);
    }
}
