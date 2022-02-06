package com.example.data.collections

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Medication(
    val name: String,
    val weight: String,
    val image: String,
    @BsonId
    val code: String = ObjectId().toString()
)
