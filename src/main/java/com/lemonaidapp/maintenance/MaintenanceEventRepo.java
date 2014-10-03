package com.lemonaidapp.maintenance;

import java.util.*;

/**
 * Created by ddcdanter on 7/30/14.
 */
public class MaintenanceEventRepo {

	private Random RANDOM = new Random(System.currentTimeMillis());

	private static MaintenanceEventRepo instance;

    public static MaintenanceEventRepo getInstance() {
        if (instance == null) {
            instance = new MaintenanceEventRepo();
        }

        return instance;
    }
	
	private Map<Integer, MaintenanceEvent> events = new HashMap<Integer, MaintenanceEvent>();
	
	private MaintenanceEventRepo() {
        MaintenanceEvent oilChange = new MaintenanceEvent();
        Calendar oilChangeCal = Calendar.getInstance();
        oilChangeCal.set(2014, 4, 15);
        oilChange.setDate(oilChangeCal.getTime());
        oilChange.setTask("Changed Oil");
        oilChange.setComments("4 Quarts Mobil1");
        oilChange.setMileage(12345);
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
        brakeWork.setMileage(67890);
        brakeWork.setId(RANDOM.nextInt(Integer.MAX_VALUE));
        events.put(brakeWork.getId(), brakeWork);
	}

    public void createEvent(MaintenanceEvent event) {
        this.events.put(event.getId(), event);
    }

    public void deleteEvent(MaintenanceEvent event) {
        this.events.remove(event.getId());
    }
	
	public List<MaintenanceEvent> findAllEvents() {
		return new ArrayList<MaintenanceEvent>(this.events.values());
	}
	
	public MaintenanceEvent findEventById(int id) {
        return this.events.get(id);
	}
	
	public List<MaintenanceEvent> findEventsForVehicle(String vehicleName) {
		// TODO: implement findEventsForVehicle
        List<MaintenanceEvent> list = new ArrayList<MaintenanceEvent>(this.events.values());
        int size = list.size();
        for (int i=0; i<size;i++) {
            MaintenanceEvent currentEvent = list.get(i);
            if (!currentEvent.getVehicleName().equals(vehicleName)){
                list.remove(i);
                size = list.size();
            }
        }
		return list;
	}

    public List<MaintenanceEvent> findEventsByTask(String task) {
        List<MaintenanceEvent> list = new ArrayList<MaintenanceEvent>(this.events.values());
        int size = list.size();
        for (int i=0; i<size;i++) {
            MaintenanceEvent currentEvent = list.get(i);
            if (!currentEvent.getTask().equals(task)){
                list.remove(i);
                size = list.size();
            }
        }
        return list;
    }


    public List<MaintenanceEvent> findEventsByMileage(int mileage) {
        List<MaintenanceEvent> list = new ArrayList<MaintenanceEvent>(this.events.values());
        int size = list.size();
        for (int i=0; i<size;i++) {
            MaintenanceEvent currentEvent = list.get(i);
            if (currentEvent.getMileage() != mileage){
                list.remove(i);
                size = list.size();
            }
        }
        return list;
    }
}
