package com.lemonaidapp.maintenance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by ddcdanter on 7/30/14.
 */
public class MaintenanceEventRepo {

	private Random RANDOM = new Random(System.currentTimeMillis());
	private static MaintenanceEventRepo instance;
	
	private Map<Integer, MaintenanceEvent> events;
	
	private MaintenanceEventRepo() {
        MaintenanceEvent oilChange = new MaintenanceEvent();
        Calendar oilChangeCal = Calendar.getInstance();
        oilChangeCal.set(2014, 4, 15);
        oilChange.setDate(oilChangeCal.getTime());
        oilChange.setTask("Changed Oil");
        oilChange.setComments("4 Quarts Mobil1");
        oilChange.setVehicleName("Subaru Impreza");
        oilChange.setId(RANDOM.nextInt(Integer.MAX_VALUE));
        events.put(oilChange.getId(), oilChange);

        MaintenanceEvent brakeWork = new MaintenanceEvent();
        Calendar brakeWorkCal = Calendar.getInstance();
        brakeWorkCal.set(2014, 4, 15);
        brakeWork.setDate(brakeWorkCal.getTime());
        brakeWork.setTask("Changed Brake Pads");
        brakeWork.setComments("Life expectancy: 60,000 miles");
        brakeWork.setVehicleName("Subaru Impreza");
        brakeWork.setId(RANDOM.nextInt(Integer.MAX_VALUE));
        events.put(brakeWork.getId(), brakeWork);
	}
	
	public static MaintenanceEventRepo getInstance() {
		if (instance == null) {
			instance = new MaintenanceEventRepo();
		}
		
		return instance;
	}
	
	public List<MaintenanceEvent> findAllEvents() {
		return new ArrayList<MaintenanceEvent>(this.events.values());
	}
	
	public MaintenanceEvent findEventById(int id) {
		return this.events.get(id);
	}

    public MaintenanceEvent findSingleEvent() {
    	// TODO
    	// try this using isEmpty to simplify the code
    	// change to always load first in list

        if(this.events.isEmpty()){
            return null;
        }
        return this.events.values().iterator().next();
    }
	
	public void createEvent(MaintenanceEvent event) {
		this.events.put(event.getId(), event);
	}
}
