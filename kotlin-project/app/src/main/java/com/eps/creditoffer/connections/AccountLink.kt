package com.eps.creditoffer.connections

import com.eps.creditoffer.models.Account
import com.eps.creditoffer.utils.mainAccount
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import org.json.JSONObject

class AccountLink {

    companion object{
        private val ip: String = "10.0.2.2"

        fun get(id: Int): Boolean {
            println("----AccountLink.get----")
            val url: String = "http://" + ip + ":3000/api/accounts/" + id.toString()

            val (request, response, result) = Fuel.get(url)
                .responseObject(Account.Deserializer())
            println("Response:" + response)
            val (bytes, error) = result
            if (bytes != null) {
                mainAccount.id = bytes.id
                mainAccount.agency = bytes.agency
                mainAccount.number = bytes.number
                mainAccount.balance = bytes.balance
                mainAccount.userId = bytes.userId
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
            println("----AccountLink.create----")
            val url: String = "http://" + ip + ":3000/api/accounts"

            val json = JSONObject()
            json.put("userId", userId)

            val (request, response, result) = Fuel.post(url)
                .jsonBody(json.toString())
                .responseObject(Account.Deserializer())
            println("Response:" + response)
            val (bytes, error) = result
            if (bytes != null) {
                mainAccount.id = bytes.id
                mainAccount.agency = bytes.agency
                mainAccount.number = bytes.number
                mainAccount.balance = bytes.balance
                mainAccount.userId = bytes.userId
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
}