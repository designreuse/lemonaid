package com.lemonaidapp.maintenance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaintenanceListingController extends HttpServlet {

	private final Logger log = LoggerFactory.getLogger(MaintenanceListingController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<MaintenanceEvent> events = new ArrayList<MaintenanceEvent>();
		
		MaintenanceEvent oilChange = new MaintenanceEvent();
		Calendar oilChangeCal = Calendar.getInstance();
		oilChangeCal.set(2014, 4, 15);
		oilChange.setDate(oilChangeCal.getTime());
		oilChange.setTask("Change Oil");
		oilChange.setComments("4 Quarts Mobil1");
		oilChange.setVehicleName("Subaru Impreza");
		events.add(oilChange);
		
		MaintenanceEvent brakeWork = new MaintenanceEvent();
		Calendar brakeWorkCal = Calendar.getInstance();
		brakeWorkCal.set(2014, 4, 15);
		brakeWork.setDate(brakeWorkCal.getTime());
		brakeWork.setTask("Change Oil");
		brakeWork.setComments("4 Quarts Mobil1");
		brakeWork.setVehicleName("Subaru Impreza");
		events.add(brakeWork);
		
		req.setAttribute("events", events);
		getServletContext().getRequestDispatcher("/maintenance/listing.jsp").forward(req, resp);
	}
}
