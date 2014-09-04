package com.lemonaidapp.maintenance;

import java.util.Date;

public class MaintenanceEvent {

    private Date date;
	private String vehicleName;
    private String task;
    private String comments;
    private Integer mileage;
	private int id;

	public void setDate(Date date){
        this.date = date;
    }
	
	public Date getDate(){
        return this.date;
    }

    public void setVehicleName(String name){
        this.vehicleName = name;
    }
    
    public String getVehicleName(){
        return this.vehicleName;
    }

    public void setTask(String task){
        this.task = task;
    }

    public String getTask(){
        return this.task;
    }

    public void setComments(String comments){
        this.comments = comments;
    }

    public String getComments(){
        return this.comments;
    }

    public void setMileage(Integer mileage){
        this.mileage = mileage;
    }

    public Integer getMileage(){
        return this.mileage;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}