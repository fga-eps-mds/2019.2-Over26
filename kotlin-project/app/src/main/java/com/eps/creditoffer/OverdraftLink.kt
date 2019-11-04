package com.eps.creditoffer

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.json.JSONObject
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE
import java.util.*

class OverdraftLink {

    var userCPF: Int = 0
    var firstUseDate: Date? = null
    var status: Boolean = TRUE
    var isActive: Boolean = FALSE
    var limit: Float = 0F
    var limitMax: Float = 0F
    var limitUsed: Float = 0F
    var isBlocked: Boolean = FALSE

    //private val ip: String = "192.168.0.16"
    private val ip: String = "10.0.2.2"

    class Deserializer : ResponseDeserializable<OverdraftLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, OverdraftLink::class.java)
    }

    fun get(id: Int){
        println("----OverdraftLink.get----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

        val (request, response, result) = Fuel.get(url)
            .responseObject(OverdraftLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.firstUseDate = bytes.firstUseDate
            this.isActive = bytes.status
            this.limit = bytes.limit
            this.limitMax = bytes.limitMax
            this.limitUsed = bytes.limitUsed
            this.isBlocked = bytes.isBlocked
            this.userCPF = bytes.userCPF
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

    fun create(id: Int) : Boolean{
        println("----OverdraftLink.create----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

        val json = JSONObject()
        //json.put("limit", this.limit)

        val (request, response, result) =  Fuel.post(url)
            .jsonBody(json.toString())
            .responseObject(OverdraftLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.firstUseDate = bytes.firstUseDate
            this.isActive = bytes.status
            this.limit = bytes.limit
            this.limitMax = bytes.limitMax
            this.limitUsed = bytes.limitUsed
            this.isBlocked = bytes.isBlocked
            this.userCPF = bytes.userCPF
        }
        when(result){
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

    fun cancel(id: Int){
        println("----OverdraftLink.cancel----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/cancel"

        val (request, response, result) =  Fuel.put(url)
            .responseObject(OverdraftLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.isActive = bytes.status //
        }
        when(result){
            is Result.Success -> {
                println("Success")
            }
            is Result.Failure -> {
                println("Failure")

            }
        }
    }

    fun save(id: Int){
        println("----OverdraftLink.save----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

        val json = JSONObject()
        json.put("limit", this.limit)

        val (request, response, result) =  Fuel.put(url)
            .jsonBody(json.toString())
            .responseObject(OverdraftLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            println("Save")
            this.limit = bytes.limit
            println(limit)
        }
        println(result)
        when(result){
            is Result.Success -> {
                println("Success")
            }
            is Result.Failure -> {
                println("Failure")
            }
        }
    }

    fun checkUsability(id: Int) : Boolean{
        println("----OverdraftLink.checkUsability----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/usability"

        val (request, response, result) =  Fuel.get(url)
            .response()
        println("Response:" + response)
        when(result){
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

    fun activate(id: Int) : Boolean {
        println("----OverdraftLink.activate----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/activate"

        val (request, response, result) =  Fuel.put(url)
            .responseObject(OverdraftLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.isActive = bytes.status
        }
        when(result){
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

    fun createDebt(id: Int) {
        println("----OverdraftLink.createDebt----")
        val url: String =
            "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/createDebt"

        val json = JSONObject()
        json.put("firstUseDate", this.firstUseDate)

        val (request, response, result) = Fuel.post(url)
            .jsonBody(json.toString())
            .responseObject(OverdraftLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
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
}