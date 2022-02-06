package com.example

import com.example.routes.exampleRoute
import com.example.routes.registerRoute
import com.example.routes.userRoutes
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.sessions.*
import io.ktor.auth.*
import io.ktor.gson.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        registerRoute()
        exampleRoute()
        userRoutes()
    }
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
}

data class MySession(val count: Int = 0)

