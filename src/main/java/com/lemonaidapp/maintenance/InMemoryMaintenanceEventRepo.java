package com.lemonaidapp.maintenance;

import java.util.*;

/**
 * Created by ddcdanter on 7/30/14.
 */
public class InMemoryMaintenanceEventRepo implements MaintenanceEventRepo {


    private Map<Integer, MaintenanceEvent> events = new HashMap<Integer, MaintenanceEvent>();

    private static InMemoryMaintenanceEventRepo instance;

    public static InMemoryMaintenanceEventRepo getInstance() {
        if (instance == null) {
            instance = new InMemoryMaintenanceEventRepo();
        }

        return instance;
    }

    @Override
    public void createEvent(MaintenanceEvent event) {
        this.events.put(event.getId(), event);
    }

    @Override
    public void deleteEvent(MaintenanceEvent event) {
        this.events.remove(event.getId());
    }
	
	@Override
    public List<MaintenanceEvent> findAllEvents() {
		return new ArrayList<MaintenanceEvent>(this.events.values());
	}

	@Override
    public List<MaintenanceEvent> findEventsForVehicle(String vehicleName) {
        List<MaintenanceEvent> results = new ArrayList<MaintenanceEvent>();
        for (MaintenanceEvent event : this.events.values()) {
            if (event.getVehicleName().equals(vehicleName)) {
                results.add(event);
            }
        }

        return results;
	}

    @Override
    public List<MaintenanceEvent> findEventsByTask(String task) {
        List<MaintenanceEvent> list = new ArrayList<MaintenanceEvent>(this.events.values());
        for (Iterator <MaintenanceEvent> iterator = list.iterator(); iterator.hasNext();) {
            MaintenanceEvent maintenanceEvent = iterator.next();
            if (!maintenanceEvent.getTask().equals(task)){
                iterator.remove();
            }
        }
        return list;
    }

    @Override
    public List<MaintenanceEvent> findEventsByMileage(int mileage) {
        List<MaintenanceEvent> list = new ArrayList<MaintenanceEvent>(this.events.values());
        for (Iterator<MaintenanceEvent> iterator = list.iterator(); iterator.hasNext(); ) {
            MaintenanceEvent maintenanceEvent = iterator.next();
            if (!maintenanceEvent.getMileage().equals(mileage)) {
                iterator.remove();
            }
        }
        return list;
    }

    @Override
    public MaintenanceEvent findEventById(int id) {
        return this.events.get(id);
    }
}
