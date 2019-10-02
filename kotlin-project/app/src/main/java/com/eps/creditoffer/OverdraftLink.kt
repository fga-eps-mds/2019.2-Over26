package com.eps.creditoffer

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import org.json.JSONObject
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE
import java.util.*

class OverdraftLink(){

    var user: Int = 0
    var firstUseDate: Date? = null
    var isActive: Boolean = FALSE
    var limit: Float = 0F
    var limitMax: Float = 0F
    var limitUsed: Float = 0F
    var isBlocked: Boolean = TRUE


    private val ip: String = "192.168.0.16"
    private var data = JSONObject()

    private fun parsedata(){
        println("ParseData:")
        println(data)
    }

    fun get(id: Int){

        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

        Fuel.get(url)
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
                        print("Sucecss")
                    }
                    is Result.Failure -> {
                        print("Failure")

                    }
                }
            }
    }

    fun post(id: Int){
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

        Fuel.get(url)
            .body("")
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
}