package com.lemonaidapp.maintenance;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaintenanceListingController extends HttpServlet {

	//private final Logger log = LoggerFactory.getLogger(MaintenanceListingController.class);

	private InMemoryMaintenanceEventRepo eventRepo;
    private JbdcMaintenanceEventRepo jbdcMaintenanceEventRepo;
	
	public MaintenanceListingController() {
		this.jbdcMaintenanceEventRepo = JbdcMaintenanceEventRepo.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<MaintenanceEvent> events = null;
        int mileage = -1;
        String vehicleName = "";
        String task = "";

            try {
                events = this.jbdcMaintenanceEventRepo.findAllEvents();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if (req.getParameter("vehicleName") != null) {
            vehicleName = req.getParameter("vehicleName");
            if (vehicleName.isEmpty()) {
                resp.sendError(500, "Error loading maintenance event");
            }
            events = this.jbdcMaintenanceEventRepo.findEventsForVehicle(vehicleName);
        }

        if (req.getParameter("task") != null) {
            task = req.getParameter("task");
            System.out.println(task);
            if (task.isEmpty()) {
                resp.sendError(500, "Error loading maintenance event");
            }
            events = this.jbdcMaintenanceEventRepo.findEventsByTask(task);
        }

        if (req.getParameter("mileage") != null) {
            mileage = Integer.parseInt(req.getParameter("mileage"));
            if (mileage == -1) {
                resp.sendError(500, "Error loading maintenance event");
            }
            events = this.jbdcMaintenanceEventRepo.findEventsByMileage(mileage);
        }
		
        req.setAttribute("events", events);
        getServletContext().getRequestDispatcher("/maintenance/listing.jsp").forward(req, resp);
	}
}
