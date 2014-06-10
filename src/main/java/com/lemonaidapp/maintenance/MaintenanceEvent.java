package com.lemonaidapp.maintenance;

import java.util.Date;

public class MaintenanceEvent {

    private Date date;
	private String vehicleName;

	public void setDate(Date date){
        this.date = date;
    }
	
	public Date getDate(Date date){
        return this.date;
    }

    public void setVehicleName(String name){
        this.vehicleName = name;
    }
    
    public String getVehicleName(String name){
        return this.vehicleName;
    }

//    public String description(ModelMap model){
//        return "index.jsp";
//    }
//
//    public String notes(ModelMap model){
//        return "index.jsp";
//    }
//
//    public String mileage(ModelMap model){
//        return "index.jsp";
//    }


}
