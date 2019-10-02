package com.eps.creditoffer

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.await
import com.github.kittinunf.fuel.core.awaitResponse
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.fuel.coroutines.awaitObjectResponse
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import kotlinx.coroutines.*
import org.json.JSONObject
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE
import java.util.*
import java.util.concurrent.BlockingDeque

class OverdraftLink(){


    var user: Int = 0
    var firstUseDate: Date? = null
    var isActive: Boolean = TRUE
    var limit: Float = 0F
    var limitMax: Float = 0F
    var limitUsed: Float = 0F
    var isBlocked: Boolean = FALSE

    private val ip: String = "192.168.43.224"

    class Deserializer : ResponseDeserializable<OverdraftLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, OverdraftLink::class.java)
    }

    fun get(id: Int, r: TrackLimit){

        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"


        /*runBlocking {
            val (request, response, result) = Fuel.get(url).awaitStringResponseResult()

            result.fold(
                { data -> println("***************************" + data ) /* "{"origin":"127.0.0.1"}" */ },
                { error -> println("An error of type ${error.exception} happened: ${error.message}") }
            )


        }*/
/*

        val (request, response, result) = url.httpGet().responseString()

        when(result){
            is Result.Success -> {
                val data = result.get()
                print(data)
            }
            is Result.Failure -> {
                val ex = result.getException()
                print(ex)

            }
        }


        runBlocking {*/
            Fuel.get(url)
                .responseObject(OverdraftLink.Deserializer()) { request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("Atualizou --------------")
                        println(bytes.limitUsed)

                        this.isActive = bytes.isActive
                        this.limit = bytes.limit
                        println(limit)
                        this.limitMax = bytes.limitMax
                        this.limitUsed = bytes.limitUsed
                        this.isBlocked = bytes.isBlocked
                        println(limitUsed)

                        r.initSeekBar(this)
                        //data.getJSONArray(bytes.toString())
                        //parsedata()
                    }
                    println(result)
                    when (result) {
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

        var json = JSONObject()
        json.put("limit", this.limit)

        Fuel.put(url)
            .jsonBody(json.toString())
            .responseObject(OverdraftLink.Deserializer()) { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    println("Save")
                    this.limit = bytes.limit
                    println(limit)
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