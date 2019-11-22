package com.eps.creditoffer.connections

import com.eps.creditoffer.BuildConfig
import com.eps.creditoffer.models.Overdraft
import com.eps.creditoffer.utils.currentOverdraft
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.json.JSONObject
import java.lang.Boolean.FALSE
import java.util.*

class OverdraftLink {
    companion object{
        private val ip: String =  BuildConfig.BASE_URL

        fun get(id: Int): Boolean {
            println("----OverdraftLink.get----")
            val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

            val (request, response, result) = Fuel.get(url)
                .responseObject(Overdraft.Deserializer())
            println("Response:" + response)
            val (bytes, error) = result
            if (bytes != null) {
                currentOverdraft.firstUseDate = bytes.firstUseDate
                currentOverdraft.isActive = bytes.isActive
                currentOverdraft.limit = bytes.limit
                currentOverdraft.limitMax = bytes.limitMax
                currentOverdraft.limitUsed = bytes.limitUsed
                currentOverdraft.isBlocked = bytes.isBlocked
                currentOverdraft.userCPF = bytes.userCPF
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

        fun create(id: Int): Boolean {
            println("----OverdraftLink.create----")
            val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

            val json = JSONObject()
            // json.put("limit", this.limit)

            val (request, response, result) = Fuel.post(url)
                .jsonBody(json.toString())
                .responseObject(Overdraft.Deserializer())
            println("Response:" + response)
            val (bytes, error) = result
            if (bytes != null) {
                currentOverdraft.id = bytes.id
                currentOverdraft.firstUseDate = bytes.firstUseDate
                currentOverdraft.isActive = bytes.isActive
                currentOverdraft.limit = bytes.limit
                currentOverdraft.limitMax = bytes.limitMax
                currentOverdraft.limitUsed = bytes.limitUsed
                currentOverdraft.isBlocked = bytes.isBlocked
                currentOverdraft.userCPF = bytes.userCPF
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

        fun cancel(id: Int) {
            println("----OverdraftLink.cancel----")
            val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/cancel"

            val (request, response, result) = Fuel.put(url)
                .responseObject(Overdraft.Deserializer())
            println("Response:" + response)
            val (bytes, error) = result
            if (bytes != null) {
                currentOverdraft.isActive = bytes.isActive
            }
            when (result) {
                is Result.Success -> {
                    println("Success")
                }
                is Result.Failure -> {
                    println("Failure")
                }
            }
        }

        fun save(id: Int) {
            println("----OverdraftLink.save----")
            val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

            val json = JSONObject()
            json.put("limit", currentOverdraft.limit)

            val (request, response, result) = Fuel.put(url)
                .jsonBody(json.toString())
                .responseObject(Overdraft.Deserializer())
            println("Response:" + response)
            val (bytes, error) = result
            if (bytes != null) {
                println("Save")
                currentOverdraft.limit = bytes.limit
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

        fun checkUsability(id: Int): Boolean {
            println("----OverdraftLink.checkUsability----")
            val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/usability"

            val (request, response, result) = Fuel.get(url)
                .response()
            println("Response:" + response)
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

        fun activate(id: Int): Boolean {
            println("----OverdraftLink.activate----")
            val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/activate"

            val (request, response, result) = Fuel.put(url)
                .responseObject(Overdraft.Deserializer())
            println("Response:" + response)
            val (bytes, error) = result
            if (bytes != null) {
                currentOverdraft.isActive = bytes.isActive
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