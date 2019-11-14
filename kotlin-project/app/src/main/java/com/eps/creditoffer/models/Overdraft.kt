package com.eps.creditoffer.models

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import java.util.*

class Overdraft {

    var userCPF: Int = 0
    var firstUseDate: Date? = null
    var isActive: Boolean = java.lang.Boolean.FALSE
    var limit: Float = 0F
    var limitMax: Float = 0F
    var limitUsed: Float = 0F
    var isBlocked: Boolean = java.lang.Boolean.FALSE


    class Deserializer : ResponseDeserializable<Overdraft> {
        override fun deserialize(content: String) = Gson().fromJson(content, Overdraft::class.java)
    }
}