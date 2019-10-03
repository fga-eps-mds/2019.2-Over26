package com.eps.creditoffer

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.json.JSONObject
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE
import java.util.*

class OverdraftLink(){

    var user: Int = 0
    var firstUseDate: Date? = null
    var status: Boolean = TRUE
    var isActive: Boolean = TRUE
    var limit: Float = 0F
    var limitMax: Float = 0F
    var limitUsed: Float = 0F
    var isBlocked: Boolean = TRUE

    private val ip: String = "192.168.0.16"

    class Deserializer : ResponseDeserializable<OverdraftLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, OverdraftLink::class.java)
    }

    fun get(id: Int, r: TrackLimit){
        println("----OverdraftLink.get----")

        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts"

        Fuel.get(url)
            .responseObject(OverdraftLink.Deserializer()) { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    this.isActive = bytes.status
                    this.limit = bytes.limit
                    this.limitMax = bytes.limitMax
                    this.limitUsed = bytes.limitUsed
                    this.isBlocked = bytes.isBlocked

                    r.initSeekBar(this)
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

        var json = JSONObject()
        //json.put("limit", this.limit)

        Fuel.post(url)
            .jsonBody(json.toString())
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

    fun cancel(id: Int){
        println("----OverdraftLink.cancel----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/cancel"

        Fuel.put(url)
            .responseObject(OverdraftLink.Deserializer()) { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    this.isActive = bytes.status //
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
        println("----OverdraftLink.save----")
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

    fun checkUsability(id: Int, r: eligibilidade){
        println("----OverdraftLink.checkUsability----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/usability"

        Fuel.get(url)
            .response() { request, response, result ->
                println(request)
                println(response)
                println(result)
                when(result){
                    is Result.Success -> {
                        print("Sucecss")
                        val intent = Intent(r, TelaDeConfirmacaoChequeEspecial::class.java)
                        startActivity(r, intent, null)
                    }
                    is Result.Failure -> {
                        print("Failure")

                    }
                }
            }
    }

    fun activate(id: Int, r: TelaDeConfirmacaoChequeEspecial){
        println("----OverdraftLink.activate----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/activate"

        Fuel.put(url)
            .responseObject(OverdraftLink.Deserializer()) { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    this.isActive = bytes.status //
                }
                println(result)
                when(result){
                    is Result.Success -> {
                        print("Sucecss")
                        val intent = Intent(r, TrackLimit::class.java)
                        startActivity(r, intent, null)
                    }
                    is Result.Failure -> {
                        print("Failure")

                    }
                }
            }
    }
}