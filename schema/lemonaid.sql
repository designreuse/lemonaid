DROP TABLE IF EXISTS maintenance_events;
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
VALUES ("My Subaru","Oil change",21345,56789,"This is a test");

INSERT INTO maintenance_events
(VehicleName,Task,Mileage,Id,Comments)
VALUES ("My Ford","Tire change",100101,12345,"This is a second test");

INSERT INTO maintenance_events
(VehicleName,Task,Mileage,Id,Comments)
VALUES ("My Ford","New Battery",53019,92831,"This is a third test");

INSERT INTO maintenance_events
(VehicleName,Task,Mileage,Id,Comments)
VALUES ("My Jeep","State Inspection",73593,65748,"This is a fourth test");
