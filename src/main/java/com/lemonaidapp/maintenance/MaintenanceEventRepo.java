package com.lemonaidapp.maintenance;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ddcdanter on 12/2/14.
 */
public interface MaintenanceEventRepo {

    void createEvent(MaintenanceEvent event) throws SQLException;

    void deleteEvent(MaintenanceEvent event);

    List<MaintenanceEvent> findAllEvents() throws SQLException, ClassNotFoundException;

    List<MaintenanceEvent> findEventsForVehicle(String vehicleName);

    List<MaintenanceEvent> findEventsByTask(String task);

    List<MaintenanceEvent> findEventsByMileage(int mileage);

    MaintenanceEvent findEventById(int id);
}
