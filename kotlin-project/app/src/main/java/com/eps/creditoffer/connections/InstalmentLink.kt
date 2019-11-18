package com.eps.creditoffer.connections

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Reader
import java.lang.Boolean.FALSE
import java.util.*

class InstalmentLink {

    val isPaid: Boolean = FALSE
    val value: Float = 0F
    val dueDate: Date = Date()

    class Deserializer : ResponseDeserializable<InstalmentLink> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, InstalmentLink::class.java)
    }

    class ListDeserializer : ResponseDeserializable<List<InstalmentLink>> {
        override fun deserialize(reader: Reader): List<InstalmentLink> {
            val type = object : TypeToken<List<InstalmentLink>>() {}.type
            return Gson().fromJson(reader, type)
        }
    }
}
