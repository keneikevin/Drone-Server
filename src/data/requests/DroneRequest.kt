package com.example.data.requests

import com.example.data.collections.Medication

data class DroneRequest(
    val serialNumber: String,
    val model: String,
    val battery: String,
    val weightLimit: String,
    val state: String,
    val medications:String
    //val medications: List<String>
)