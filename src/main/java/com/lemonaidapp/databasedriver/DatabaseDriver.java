package com.lemonaidapp.databasedriver;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ddcdanter on 11/18/14.
 */
public class DatabaseDriver {

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/lemonaid";
        String username = "root";
        String password = "";

        try {
            return DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void viewTable() throws SQLException, NullPointerException {

        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        String query = "SELECT * FROM MaintenanceEventRepo";

        try {
            con = this.getConnection();
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

    public void setDatabase() throws NullPointerException {
        String s;
        StringBuffer sb = new StringBuffer();
        Statement stmt = null;
        Connection con = null;

        try
        {
            con = this.getConnection();
            FileReader fr = new FileReader(new File("mySQLFile.sql"));
            // be sure to not have line starting with "--" or "/*" or any other non aplhabetical character

            BufferedReader br = new BufferedReader(fr);

            while((s = br.readLine()) != null)
            {
                sb.append(s);
            }
            br.close();

            // here is our splitter ! We use ";" as a delimiter for each request
            // then we are sure to have well formed statements
            String[] inst = sb.toString().split(";");

            Connection c = Database.getConnection();
            Statement st = c.createStatement();

            for(int i = 0; i<inst.length; i++)
            {
                // we ensure that there is no spaces before or after the request string
                // in order to not execute empty statements
                if(!inst[i].trim().equals(""))
                {
                    st.executeUpdate(inst[i]);
                    System.out.println(">>"+inst[i]);
                }
            }

        }
        catch(Exception e){}
    }
}