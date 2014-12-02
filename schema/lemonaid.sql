CREATE DATABASE lemonaid;

CREATE TABLE maintenance_events
(
VehicleName varchar(255),
Task varchar(255),
Comments varchar(255),
Mileage int,
Id int PRIMARY KEY,
Date date
);

INSERT INTO maintenance_events
(VehicleName,Task,Mileage,Id,Comments)
VALUES ("My Subaru","Oil change",21345,019283756,"This is a test");
VALUES ("My Ford","Tire change",100101,5647382910,"This is a second test");
