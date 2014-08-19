package com.lemonaidapp.maintenance;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
        newEvent.setVehicleName(req.getParameter("vehicleName"));
        
        this.eventRepo.createEvent(newEvent);
        
		List<MaintenanceEvent> events = this.eventRepo.findAllEvents();
		
		req.setAttribute("events", events);
        getServletContext().getRequestDispatcher("/maintenance/listing.jsp").forward(req, resp);
	}
}
