package com.example.routes


import com.example.MySession
import com.example.data.checkIfDroneExists
import com.example.data.collections.Drone
import com.example.data.registerDrone
import com.example.data.requests.DroneRequest
import com.example.data.responses.SimpleResponse
import io.ktor.application.call
import io.ktor.features.ContentTransformationException
import io.ktor.http.*
import io.ktor.http.HttpStatusCode.Companion.BadRequest
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.request.receive
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.sessions.*
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import sun.security.util.Password

fun Route.exampleRoute() {

    route("/user") {
        get {
            call.respond(User("1","jatay","kekeek","jssns"))
        }



    }
}

data class User(
    @BsonId
    val userId:String? = ObjectId().toString(),
    val username:String?,
    val email:String?,
    val password:String?,
)