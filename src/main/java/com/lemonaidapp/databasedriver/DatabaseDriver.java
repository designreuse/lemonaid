package com.lemonaidapp.databasedriver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ddcdanter on 11/18/14.
 */
public class DatabaseDriver {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/lemonaid";
        //String username = "username";
        //String password = "password";

        try {
            Connection con = DriverManager.getConnection(url);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM MaintenanceEventRepo");

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
        } catch (SQLException e) {
            e.printStackTrace();
        } //finally {
            //try {
                //if (){}
            //} catch (SQLException e){
                //e.printStackTrace();
            //}
        }
}
