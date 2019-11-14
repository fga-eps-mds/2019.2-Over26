package com.eps.creditoffer.connections

import com.eps.creditoffer.models.User
import com.eps.creditoffer.utils.mainUser
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
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
                mainUser.id = bytes.id
                mainUser.cpf = bytes.cpf
                mainUser.name = bytes.name
                mainUser.email = bytes.email
                mainUser.phone = bytes.phone
                mainUser.monthlyIncome = bytes.monthlyIncome
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

        fun create(name: String): Boolean {
            println("----UserLink.create----")
            val url: String = "http://" + ip + ":3000/api/users"

            val json = JSONObject()
            json.put("name", name)

            println("Name: "+ name)

            val (_, response, result) = Fuel.post(url)
                .jsonBody(json.toString())
                .responseObject(User.Deserializer())
            println("Response:" + response)
            val (bytes, error) = result
            if (bytes != null) {
                mainUser.id = bytes.id
                mainUser.cpf = bytes.cpf
                mainUser.name = bytes.name
                mainUser.email = bytes.email
                mainUser.phone = bytes.phone
                mainUser.monthlyIncome = bytes.monthlyIncome

                println("User.name: "+ mainUser.name)
                println("bytes.name: "+ bytes.name)
            }
            println(result)
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

        fun listDebt(id: Int): Boolean {
            println("----User.listDebt---")

            val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString() + "/listDebt"
            val (request, response, result) = Fuel.get(url)
                .responseObject(OverdraftDebtLink.ListDeserializer())
            println("Response:" + response)
            val (bytes, error) = result
            print("Bytes: " + bytes)

            if (bytes != null) {
                mainUser.debt = bytes
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