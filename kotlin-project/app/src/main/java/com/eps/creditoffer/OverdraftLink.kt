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

class OverdraftLink(var user: Int = 0,
                    var firstUseDate: Date? = null,
                    var isActive: Boolean = TRUE,
                    var limit: Float = 0F,
                    var limitMax: Float = 0F,
                    var limitUsed: Float = 0F,
                    var isBlocked: Boolean = FALSE){




    private val ip: String = "192.168.0.16"

    class Deserializer : ResponseDeserializable<OverdraftLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, OverdraftLink::class.java)
    }

    fun get(id: Int){

        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

        Fuel.get(url)
            .responseObject(OverdraftLink.Deserializer()) { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    println("Atualizou --------------")
                    println(bytes.limit)

                    isActive = bytes.isActive
                    limit = bytes.limit
                    println(limit)
                    limitMax = bytes.limitMax
                    limitUsed = bytes.limitUsed
                    isBlocked = bytes.isBlocked
                    //data.getJSONArray(bytes.toString())
                    //parsedata()
                }
                println(result)
                when(result){
                    is Result.Success -> {
                        print("Sucecss")
                    }
                    is Result.Failure -> {
                        print("Failure")

                    }
                }
            }
    }

    fun create(id: Int){
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

        Fuel.post(url)
            //.body("{\"limit\": " + limit.toString() + "}")
            .response { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    println("[response bytes] ${String(bytes)}")
                    //data.getJSONArray(bytes.toString())
                    //parsedata()
                }
                println(result)
                when(result){
                    is Result.Success -> {

                    }
                    is Result.Failure -> {

                    }
                }
            }
    }

    fun put(id: Int){

        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

        Fuel.get(url)
            .body("{" +
                    "\"limitUsed\": 50," +
                    "\"firstUseDate\": \"2019-09-02T01:10:53.081Z\"}")
            .response { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    println("[response bytes] ${String(bytes)}")
                }
                println(result)
                when(result){
                    is Result.Success -> {
                        print("Sucecss")
                    }
                    is Result.Failure -> {
                        print("Failure")

                    }
                }
            }
    }

    fun cancel(id: Int){
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/cancel"

        Fuel.put(url)
            .responseObject(OverdraftLink.Deserializer()) { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    println("Cancel")
                }
                println(result)
                when(result){
                    is Result.Success -> {
                        print("Sucecss")
                    }
                    is Result.Failure -> {
                        print("Failure")

                    }
                }
            }
    }

    fun save(id: Int){
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

        Fuel.put(url)
            .body("{\"limit\": " + limit + "}")
            .responseObject(OverdraftLink.Deserializer()) { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    println("Save")
                }
                println(result)
                when(result){
                    is Result.Success -> {
                        print("Sucecss")
                    }
                    is Result.Failure -> {
                        print("Failure")

                    }
                }
            }
    }
}