package com.example.routes

import com.example.data.*
import com.example.data.collections.Drone
import com.example.data.collections.Medication
import com.example.data.requests.AddMedicRequest
import com.example.data.responses.SimpleResponse
import io.ktor.application.call
import io.ktor.features.ContentTransformationException
import io.ktor.http.HttpStatusCode.Companion.BadRequest
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.userRoutes(){
    route("/addMedication"){
        post {
            val requestBody = call.receive<Medication>()
            val medication = addMedication(requestBody)
            call.respond(medication)
        }
    }
    route("/drones"){
        get {
            val drones = getDrones()
            call.respond(drones)
        }
    }
    route("/addDrone") {
    post {
        val requestBody = call.receive<Drone>()
        val drone = addDrone(requestBody)
        call.respond(drone)
    }
    }
    route("/addMedicToDrone") {
            post {
                val request = try {
                    call.receive<AddMedicRequest>()
                } catch(e: ContentTransformationException) {
                    call.respond(BadRequest)
                    return@post
                }
                if(!checkIfDroneExists(request.medic)) {
                    call.respond(
                        OK,
                        SimpleResponse(false, "No drone with this Serial No exists")
                    )
                    return@post
                }

            }

    }
}


