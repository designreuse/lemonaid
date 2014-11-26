CREATE DATABASE lemonaid;

CREATE TABLE maintenance_events
(
VehicleName varchar(255),
Task varchar(255),
Comments varchar(255),
Mileage int,
Id int,
Date date
);

insert into maintenance_events
(
VehicleName,
Task,
Mileage,
Id,
Comments
)

values
(
"My Subaru",
"Oil change",
21345,
019283756,
"This is a test"
);
