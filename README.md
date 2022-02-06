# Drone-Server

Introduction
Clone Project and have Mongo Atlas for referrence.
Navigate to src -. Application.kt file and run the activity.


Use this as your base URL (http://localhost:8080)

Register Drone

(POST) http://localhost:8080/addDrone

serialNumber:String,
model:Primitive, can be (Lightweight, Middleweight, Cruiserweight,
Heavyweight);
medications:String,
battery:String,
weightLimit:String,
state:Primitive; can be(IDLE, LOADING, LOADED, DELIVERING, DELIVERED,
RETURNING).

(POST) http://localhost:8080/addMedication

add medication to database
takes in json objects
name:String,
weight:Float,
code:String,
image:String,


(GET) http://localhost:8080/addMedication/drones

view all drones
returns a list of drones above 25% battery

(POST) http://localhost:8080/addMedication/dronesaddMedicToDrone
add medication to a drone
takes in json objects
serialNo:String
medicationName:Sting

