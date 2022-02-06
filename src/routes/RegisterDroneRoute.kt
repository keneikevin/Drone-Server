package com.example.routes


import com.example.data.checkIfDroneExists
import com.example.data.collections.Drone
import com.example.data.registerDrone
import com.example.data.requests.DroneRequest
import com.example.data.responses.SimpleResponse
import io.ktor.application.call
import io.ktor.features.ContentTransformationException
import io.ktor.http.HttpStatusCode.Companion.BadRequest
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.registerRoute() {
    route("/register") {
        post {
            val request = try {
                call.receive<DroneRequest>()
            } catch(e: ContentTransformationException) {
                call.respond(BadRequest)
                return@post
            }
            val droneExists = checkIfDroneExists(request.serialNumber)
            if(!droneExists) {
                if(
                    registerDrone(
                        Drone(
                            request.serialNumber,
                            request.model,
                            request.weightLimit,
                            request.state,
                            request.battery,
                            request.medications
                        )
                    )
                ) {
                    call.respond(OK, SimpleResponse(true, "Successfully registered drone!"))
                } else {
                    call.respond(OK, SimpleResponse(false, "An unknown error occured"))
                }
            } else {
                call.respond(OK, SimpleResponse(false, "A user with that E-Mail already exists"))
            }
        }
    }
}