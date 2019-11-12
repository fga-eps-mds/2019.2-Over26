package com.eps.creditoffer.Connections

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import org.json.JSONObject
import java.util.*

class StartLink {

    // private val ip: String = "192.168.0.16"
    private val ip: String = "10.0.2.2"

    fun start(nome: String): Boolean {
        println("----StartLink.create----")
        val url: String = "http://" + ip + ":3000/api/start"

        val json = JSONObject()
        json.put("name", nome)
        println("json: " + json.toString())

        val (request, response, result) = Fuel.post(url)
            .jsonBody(json.toString())
            .response()
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            println(bytes)
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