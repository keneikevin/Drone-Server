package com.example.data

import com.example.data.collections.Drone
import com.example.data.collections.Medication
import com.example.routes.User
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.coroutine.toList
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.setValue

private val client = KMongo.createClient().coroutine
private val database = client.getDatabase("DronesDatabase")
private val drones = database.getCollection<Drone>()
private val medications = database.getCollection<Medication>()
private val userCollection = database.getCollection<User>()




suspend fun registerDrone(drone: Drone): Boolean {
    return drones.insertOne(drone).wasAcknowledged()
}

suspend fun checkIfDroneExists(serialNumber: String): Boolean {
    return drones.findOne(Drone::serialNumber eq serialNumber) != null
}

suspend fun addDrone(drone: Drone):Drone{
    drones.insertOne(drone)
    return drone
}


suspend fun addMedicationToDrone(noteID: String, owner: String): Boolean {
    val owners = drones.findOneById(noteID)?.serialNumber ?: return false
    return drones.updateOneById(noteID, setValue(Drone::serialNumber, owners + owner)).wasAcknowledged()
}


suspend fun getDrones(): List<Drone> {
    return drones.collection.find().toList()
}

suspend fun addMedication(medication: Medication):Medication{
    medications.insertOne(medication)
    return medication
}






































