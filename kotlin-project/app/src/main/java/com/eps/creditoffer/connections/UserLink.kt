package com.eps.creditoffer.connections

import com.eps.creditoffer.models.User
import com.eps.creditoffer.utils.currentUser
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import org.json.JSONObject

class UserLink {
    companion object {
        private const val ip: String = "10.0.2.2"

        fun get(id: Int): Boolean {
            println("----UserLink.get----")
            val url = "http://$ip:3000/api/users/$id"

            val (_, _, result) = Fuel.get(url)
                .responseObject(User.Deserializer())
            val (bytes, _) = result
            if (bytes != null) {
                currentUser.id = bytes.id
                currentUser.cpf = bytes.cpf
                currentUser.name = bytes.name
                currentUser.email = bytes.email
                currentUser.phone = bytes.phone
                currentUser.monthlyIncome = bytes.monthlyIncome
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
            val url = "http://$ip:3000/api/users"

            val json = JSONObject()
            json.put("name", name)

            val (_, _, result) = Fuel.post(url)
                .jsonBody(json.toString())
                .responseObject(User.Deserializer())
            val (bytes, _) = result
            if (bytes != null) {
                currentUser.id = bytes.id
                currentUser.cpf = bytes.cpf
                currentUser.name = bytes.name
                currentUser.email = bytes.email
                currentUser.phone = bytes.phone
                currentUser.monthlyIncome = bytes.monthlyIncome

                println("User.name: "+ currentUser.name)
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

            val url = "http://$ip:3000/api/overdraftDebts/$id/listDebt"
            val (_, _, result) = Fuel.get(url)
                .responseObject(OverdraftDebtLink.ListDeserializer())
            val (bytes, _) = result
            if (bytes != null) {
                currentUser.debt = bytes
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