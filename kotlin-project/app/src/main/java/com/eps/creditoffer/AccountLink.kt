package com.eps.creditoffer

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.json.JSONObject
import java.util.*

class AccountLink {

    var userId: Int = 1
    var id: Int = 0
    var agency: Int = 0
    var number: Int = 0
    var balance: Float = 0F

    // private val ip: String = "192.168.0.16"
    private val ip: String = "10.0.2.2"

    class Deserializer : ResponseDeserializable<AccountLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, AccountLink::class.java)
    }

    fun get(id: Int): Boolean {
        println("----AccountLink.get----")
        val url: String = "http://" + ip + ":3000/api/accounts/" + id.toString()

        val (request, response, result) = Fuel.get(url)
            .responseObject(AccountLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.id = bytes.id
            this.agency = bytes.agency
            this.number = bytes.number
            this.balance = bytes.balance
            this.userId = bytes.userId
        }
        when (result) {
            is Result.Success -> {
                println("Success")
                return true
            }
            is Result.Failure -> {
                println("Failure")
                return false
            }
        }
    }

    fun create(userId: Int): Boolean {
        val idOfUser = userId
        println("----AccountLink.create----")
        val url: String = "http://" + ip + ":3000/api/accounts"

        val json = JSONObject()
        json.put("userId", idOfUser)
        json.put("agency", this.agency)
        json.put("number", this.number)
        json.put("balance", this.balance)

        val (request, response, result) = Fuel.post(url)
            .jsonBody(json.toString())
            .responseObject(AccountLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.id = bytes.id
            this.agency = bytes.agency
            this.number = bytes.number
            this.balance = bytes.balance
            this.userId = bytes.userId
        }
        when (result) {
            is Result.Success -> {
                return true
                println("Success")
            }
            is Result.Failure -> {
                return false
                println("Failure")
            }
        }
    }

    fun put(id: Int): Boolean {
        println("----AccountLink.create----")
        val url: String = "http://" + ip + ":3000/api/accounts" + id.toString()

        val json = JSONObject()
        json.put("userId", this.userId)
        json.put("agency", this.agency)
        json.put("number", this.number)
        json.put("userId", this.userId)

        val (request, response, result) = Fuel.post(url)
            .jsonBody(json.toString())
            .responseObject(AccountLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.id = bytes.id
            this.agency = bytes.agency
            this.number = bytes.number
            this.balance = bytes.balance
            this.userId = bytes.userId
        }
        when (result) {
            is Result.Success -> {
                return true
                println("Success")
            }
            is Result.Failure -> {
                return false
                println("Failure")
            }
        }
    }
}