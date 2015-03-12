package com.lemonaidapp.maintenance;

import com.lemonaidapp.databasedriver.DatabaseDriver;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by ddcdanter on 12/2/14.
 */
public class JbdcMaintenanceEventRepo implements MaintenanceEventRepo {
    private DataSource dataSource;

    public JbdcMaintenanceEventRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    @Override
//    public void createEvent(MaintenanceEvent event) {
//        String query = "INSERT INTO table_name VALUES " +
//                "(" +
//                event.getVehicleName() +
//                event.getTask() +
//                event.getMileage() +
//                event.getId() +
//                event.getComments() +
//                ")";
//
//        try {
//            Statement stmt = this.dataSource.getConnection().createStatement();
//            stmt.executeQuery(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void createEvent(MaintenanceEvent event) {
        String query = "INSERT INTO table_name VALUES " +
                "(" +
                event.getVehicleName() +
                event.getTask() +
                event.getMileage() +
                event.getId() +
                event.getComments() +
                ")";

        try {
            Statement stmt = this.dataSource.getConnection().createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEvent(MaintenanceEvent event) {
        String query = "DELETE FROM maintenance_events WHERE Id="+event.getId();

        try {
            Statement stmt = this.dataSource.getConnection().createStatement();
            stmt.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MaintenanceEvent> findAllEvents() throws SQLException {
        String query = "SELECT * FROM maintenance_events";

        List<MaintenanceEvent> events = new ArrayList<MaintenanceEvent>();

        try {
            Statement stmt = this.dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    MaintenanceEvent me = new MaintenanceEvent();
                    me.setVehicleName(rs.getString("VehicleName"));
                    me.setTask(rs.getString("Task"));
                    me.setComments(rs.getString("Comments"));
                    me.setMileage(rs.getInt("Mileage"));
                    me.setId(rs.getInt("Id"));
                    me.setDate(rs.getDate("Date"));
                    events.add(me);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public List<MaintenanceEvent> findEventsForVehicle(String vehicleName) {
        String query = "SELECT * FROM maintenance_events WHERE VehicleName="+"\""+vehicleName+"\"";

        List<MaintenanceEvent> events = new ArrayList<MaintenanceEvent>();

        try {
            Statement stmt = this.dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    MaintenanceEvent me = new MaintenanceEvent();
                    me.setVehicleName(rs.getString("VehicleName"));
                    me.setTask(rs.getString("Task"));
                    me.setComments(rs.getString("Comments"));
                    me.setMileage(rs.getInt("Mileage"));
                    me.setId(rs.getInt("Id"));
                    me.setDate(rs.getDate("Date"));
                    events.add(me);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public List<MaintenanceEvent> findEventsByTask(String task) {
        String query = "SELECT * FROM maintenance_events WHERE Task="+"\""+task+"\"";

        List<MaintenanceEvent> events = new ArrayList<MaintenanceEvent>();

        try {
            Statement stmt = this.dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    MaintenanceEvent me = new MaintenanceEvent();
                    me.setVehicleName(rs.getString("VehicleName"));
                    me.setTask(rs.getString("Task"));
                    me.setComments(rs.getString("Comments"));
                    me.setMileage(rs.getInt("Mileage"));
                    me.setId(rs.getInt("Id"));
                    me.setDate(rs.getDate("Date"));
                    events.add(me);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public List<MaintenanceEvent> findEventsByMileage(int mileage) {
        String query = "SELECT * FROM maintenance_events WHERE Mileage="+mileage;

        List<MaintenanceEvent> events = new ArrayList<MaintenanceEvent>();

        try {
            Statement stmt = this.dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    MaintenanceEvent me = new MaintenanceEvent();
                    me.setVehicleName(rs.getString("VehicleName"));
                    me.setTask(rs.getString("Task"));
                    me.setComments(rs.getString("Comments"));
                    me.setMileage(rs.getInt("Mileage"));
                    me.setId(rs.getInt("Id"));
                    me.setDate(rs.getDate("Date"));
                    events.add(me);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public MaintenanceEvent findEventById(int id) {
        String query = "SELECT * FROM maintenance_events WHERE Id="+id;

        MaintenanceEvent me = new MaintenanceEvent();

        try {
            Statement stmt = this.dataSource.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    me.setVehicleName(rs.getString("VehicleName"));
                    me.setTask(rs.getString("Task"));
                    me.setComments(rs.getString("Comments"));
                    me.setMileage(rs.getInt("Mileage"));
                    me.setId(rs.getInt("Id"));
                    me.setDate(rs.getDate("Date"));
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return me;
    }
}
