package com.eps.creditoffer.Models

import com.eps.creditoffer.Connections.OverdraftDebtLink
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class User {

    companion object {
        var id: Int = 0
        var cpf: Int = 0
        var name: String = ""
        var email: String = ""
        var phone: Int = 0
        var monthlyIncome: Float = 0F
        var debt: List<OverdraftDebtLink> = emptyList()
    }

    class Deserializer : ResponseDeserializable<Companion> {
        override fun deserialize(content: String) = Gson().fromJson(content, Companion::class.java)
    }
}