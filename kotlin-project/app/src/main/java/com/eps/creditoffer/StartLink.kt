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

class StartLink {

    private val ip: String = "192.168.0.16"

    class Deserializer : ResponseDeserializable<StartLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, StartLink::class.java)
    }

    fun start(nome: String) : Boolean{
        println("----StartLink.create----")
        val url: String = "http://" + ip + ":3000/api/start"

        val json = JSONObject()
        json.put("nome", nome)

        val (request, response, result) =  Fuel.post(url)
            .jsonBody(json.toString())
            .responseObject(StartLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
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
}