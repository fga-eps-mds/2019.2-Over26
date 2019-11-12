package com.eps.creditoffer.Connections

import com.eps.creditoffer.Models.User
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.json.JSONObject

class UserLink {

    companion object {
        private val ip: String = "10.0.2.2"

        fun get(id: Int): Boolean {
            println("----UserLink.get----")
            val url: String = "http://" + ip + ":3000/api/users/" + id.toString()

            val (request, response, result) = Fuel.get(url)
                .responseObject(User.Deserializer())
            println("Response:" + response)
            val (bytes, error) = result
            if (bytes != null) {
                User.id = bytes.id
                User.cpf = bytes.cpf
                User.name = bytes.name
                User.email = bytes.email
                User.phone = bytes.phone
                User.monthlyIncome = bytes.monthlyIncome
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

        fun create() {
            println("----UserLink.create----")
            val url: String = "http://" + ip + ":3000/api/users"

            val json = JSONObject()
            json.put("cpf", User.cpf)

            val (request, response, result) = Fuel.post(url)
                .jsonBody(json.toString())
                .response()
            println("Response:" + response)
            val (bytes, error) = result
            if (bytes != null) {
            }
            println(result)
            when (result) {
                is Result.Success -> {
                    println("Success")
                }
                is Result.Failure -> {
                    println("Failure")
                }
            }
        }

        fun listDebt(id: Int): Boolean {
            println("----User.listDebt---")

            val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString() + "/listDebt"
            val (request, response, result) = Fuel.get(url)
                .responseObject(OverdraftDebtLink.ListDeserializer())
            println("Response:" + response)
            val (bytes, error) = result
            print("Bytes: " + bytes)

            if (bytes != null) {
                User.debt = bytes
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
    }

}