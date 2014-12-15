package com.lemonaidapp.maintenance;

import com.lemonaidapp.databasedriver.DatabaseDriver;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by ddcdanter on 12/2/14.
 */
public class JbdcMaintenanceEventRepo implements MaintenanceEventRepo {

    DatabaseDriver databaseDriver = new DatabaseDriver();

    private Map<Integer, MaintenanceEvent> events = new HashMap<Integer, MaintenanceEvent>();

    private static JbdcMaintenanceEventRepo instance;

    public static JbdcMaintenanceEventRepo getInstance() {
        if (instance == null) {
            instance = new JbdcMaintenanceEventRepo();
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
    public List<MaintenanceEvent> findAllEvents() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/lemonaid";
        String username = "root";
        String password = "";

        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        String query = "SELECT * FROM maintenance_events";

        try {
            con =  DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rs != null) {
            MaintenanceEvent me = new MaintenanceEvent();
            while (rs.next()) {
                me.setVehicleName(rs.getString("VehicleName"));
                me.setTask(rs.getString("Task"));
                me.setComments(rs.getString("Comments"));
                me.setMileage(rs.getInt("Mileage"));
                me.setId(rs.getInt("Id"));
                me.setDate(rs.getDate("Date"));
                createEvent(me);
            }
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<MaintenanceEvent>(this.events.values());
    }

    @Override
    public List<MaintenanceEvent> findEventsForVehicle(String vehicleName) {
        return null;
    }

    @Override
    public List<MaintenanceEvent> findEventsByTask(String task) {
        return null;
    }

    @Override
    public List<MaintenanceEvent> findEventsByMileage(int mileage) {
        return null;
    }

    @Override
    public MaintenanceEvent findEventById(int id) {
        return null;
    }
}
