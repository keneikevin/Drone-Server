package com.example.data.collections

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
data class Drone(
    val serialNumber: String,
    val model: String,
    val weightLimit: String,
    val state: String,
    val medications: String,
    val battery: String,
    @BsonId
    val id: String = ObjectId().toString()
)
