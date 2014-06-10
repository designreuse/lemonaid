package com.lemonaidapp.maintenance;

import java.util.Date;

public class MaintenanceEvent {

    private Date date;
	private String vehicleName;
    private String description;
    private String notes;
    private Integer mileage;

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

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(String description){
        return this.description;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

    public String getNotes(String notes){
        return this.notes;
    }

    public void setMileage(Integer mileage){
        this.mileage = mileage;
    }

    public Integer getMileage(Integer mileage){
        return this.mileage;
    }

}
