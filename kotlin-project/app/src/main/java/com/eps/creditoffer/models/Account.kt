package com.eps.creditoffer.models

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class Account {

    var userId: Int = 0
    var id: Int = 0
    var agency: Int = 0
    var number: Int = 0
    var balance: Float = 0F

    class Deserializer : ResponseDeserializable<Account> {
        override fun deserialize(content: String) = Gson().fromJson(content, Account::class.java)
    }
}