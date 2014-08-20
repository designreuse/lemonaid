package com.lemonaidapp.maintenance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by ddcdanter on 7/30/14.
 */
public class MaintenanceEventRepo {

	private static MaintenanceEventRepo instance;
	
	private List<MaintenanceEvent> events;
	
	private MaintenanceEventRepo() {
		this.events = new ArrayList<MaintenanceEvent>();

        MaintenanceEvent oilChange = new MaintenanceEvent();
        Calendar oilChangeCal = Calendar.getInstance();
        oilChangeCal.set(2014, 4, 15);
        oilChange.setDate(oilChangeCal.getTime());
        oilChange.setTask("Changed Oil");
        oilChange.setComments("4 Quarts Mobil1");
        oilChange.setVehicleName("Subaru Impreza");
        oilChange.setUuid(UUID.randomUUID());
        events.add(oilChange);

        MaintenanceEvent brakeWork = new MaintenanceEvent();
        Calendar brakeWorkCal = Calendar.getInstance();
        brakeWorkCal.set(2014, 4, 15);
        brakeWork.setDate(brakeWorkCal.getTime());
        brakeWork.setTask("Changed Brake Pads");
        brakeWork.setComments("Life expectancy: 60,000 miles");
        brakeWork.setVehicleName("Subaru Impreza");
        brakeWork.setUuid(UUID.randomUUID());
        events.add(brakeWork);
	}
	
	public static MaintenanceEventRepo getInstance() {
		if (instance == null) {
			instance = new MaintenanceEventRepo();
		}
		
		return instance;
	}
	
	public List<MaintenanceEvent> findAllEvents() {
		return this.events;
	}
	
	public void createEvent(MaintenanceEvent event) {
		this.events.add(event);
	}
}
