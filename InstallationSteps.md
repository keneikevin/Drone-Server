# Drone-Server

###Introduction


clone project and navigate to src->Application.kt and run main function, have MongoAtlas for refference.
###
open postman/insomnia use this as your base-api = "http://localhost:8080"

 "http://localhost:8080/addDrone"
Registesr Drone

  Json input
serialNumber:String,
model:String,
battery:String,
weightLimit:String,
state:String,
medications:String


POST) http://localhost:8080/addMedication

  Json input
Adds medication to our database
name:String,
weight:String,
medications:String,
image:String

 (POST) http://localhost:8080/addMedicToDrone
adds a medication to a single drone.
 Json input
 serialNo:String,
medications:String


 (GET) http://localhost:8080/drones
View all drones above 25% .
 ##Json input
 serialNo:String,
 
 

 (GET) http://localhost:8080/drones/{serialNo}
View Single Drone
and its details
