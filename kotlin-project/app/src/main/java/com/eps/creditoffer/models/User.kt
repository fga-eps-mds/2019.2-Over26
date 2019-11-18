package com.eps.creditoffer.models

import com.eps.creditoffer.connections.OverdraftDebtLink
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class User {

    var id: Int = 0
    var cpf: String = ""
    var name: String = ""
    var email: String = ""
    var phone: String = ""
    var monthlyIncome: Float = 0F
    var debt: List<OverdraftDebtLink> = emptyList()

    class Deserializer : ResponseDeserializable<User> {
        override fun deserialize(content: String): User? = Gson().fromJson(content, User::class.java)
    }
}