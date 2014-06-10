package com.lemonaidapp.maintenance;

import java.util.Date;

public class MaintenanceEvent {

    private Date date;
	private String vehicleName;
    private String vehicleDescription;
    private String vehicleNotes;
    private Integer vehicleMileage;

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

    public void setVehicleDescription(String vehicleDescription){
        this.vehicleDescription = vehicleDescription;
    }

    public String getDescription(String description){
        return this.vehicleDescription;
    }

    public void setVehicleNotes(String vehicleNotes){
        this.vehicleNotes = vehicleNotes;
    }

    public String getNotes(String notes){
        return this.vehicleNotes;
    }

    public void setVehicleMileage(Integer vehicleMileage){
        this.vehicleMileage = vehicleMileage;
    }

    public Integer getMileage(Integer mileage){
        return this.vehicleMileage;
    }

}
