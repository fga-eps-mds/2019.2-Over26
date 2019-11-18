package com.eps.creditoffer.connections

import com.eps.creditoffer.models.Account
import com.eps.creditoffer.utils.currentAccount
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import org.json.JSONObject

class AccountLink {
    companion object{

        private const val ip: String = "10.0.2.2"

        fun get(id: Int): Boolean {
            println("----AccountLink.get----")
            val url = "http://$ip:3000/api/accounts/$id"

            val (_, _, result) = Fuel.get(url)
                .responseObject(Account.Deserializer())
            val (bytes, _) = result
            if (bytes != null) {
                currentAccount.id = bytes.id
                currentAccount.agency = bytes.agency
                currentAccount.number = bytes.number
                currentAccount.balance = bytes.balance
                currentAccount.userId = bytes.userId
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
            val url = "http://$ip:3000/api/accounts"

            val json = JSONObject()
            json.put("userId", userId)

            val (_, _, result) = Fuel.post(url)
                .jsonBody(json.toString())
                .responseObject(Account.Deserializer())
            val (bytes, error) = result
            if (bytes != null) {
                currentAccount.id = bytes.id
                currentAccount.agency = bytes.agency
                currentAccount.number = bytes.number
                currentAccount.balance = bytes.balance
                currentAccount.userId = bytes.userId
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