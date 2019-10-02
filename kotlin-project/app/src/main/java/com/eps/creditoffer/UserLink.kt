package com.eps.creditoffer


import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class UserLink(){

    var cpf: Int = 0
    var name: String = ""
    var email: String = ""
    var phone: Int = 0
    var monthlyIncome: Float = 0F

    private val ip: String = "192.168.43.224"

    class Deserializer : ResponseDeserializable<UserLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, UserLink::class.java)
    }

    fun get(id: Int){

        val url: String = "http://" + ip + ":3000/api/users/" + id.toString()

        Fuel.get(url)
            .responseObject(UserLink.Deserializer()){ request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    println("[response bytes.cpf]" + bytes.cpf)
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

    fun post(){
        val url: String = "http://" + ip + ":3000/api/users"

        Fuel.post(url)
            .jsonBody("{ \"cpf\" : 1 }")
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

        val url: String = "http://" + ip + ":3000/api/users/" + id.toString()

        Fuel.get(url)
            .body("")
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