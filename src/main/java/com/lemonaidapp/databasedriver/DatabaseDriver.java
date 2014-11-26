package com.lemonaidapp.databasedriver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ddcdanter on 11/18/14.
 */
public class DatabaseDriver {

    public void viewTable(Connection con) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/lemonaid";
        String username = "root";
        String password = "";

        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM MaintenanceEventRepo";

        try {
            con = DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String vehicleName = rs.getString("VehicleName");
                String task = rs.getString("Task");
                String comments = rs.getString("Comments");
                int mileage = rs.getInt("Mileage");
                int id = rs.getInt("Id");
                Date date = rs.getDate("Date");

                System.out.println(vehicleName + "\n"
                        + task + "\n"
                        + comments + "\n"
                        + mileage + "\n"
                        + id + "\n"
                        + date + "\n");
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }
}