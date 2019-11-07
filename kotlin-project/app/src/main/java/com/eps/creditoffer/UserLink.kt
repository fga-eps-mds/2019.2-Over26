package com.eps.creditoffer


import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.json.JSONObject

class UserLink {

    var cpf: Int = 0
    var name: String = ""
    var email: String = ""
    var phone: Int = 0
    var monthlyIncome: Float = 0F
    var Debt: List<OverdraftDebtLink> = emptyList()


    //private val ip: String = "192.168.0.16"
    private val ip: String = "10.0.2.2"

    class Deserializer : ResponseDeserializable<UserLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, UserLink::class.java)
    }

    fun get(id: Int) : Boolean{
        println("----UserLink.get----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString()

        val (request, response, result) = Fuel.get(url)
            .responseObject(UserLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.cpf = bytes.cpf
            this.name = bytes.name
            this.email = bytes.email
            this.phone = bytes.phone
            this.monthlyIncome = bytes.monthlyIncome
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

    fun create(){
        println("----UserLink.create----")
        val url: String = "http://" + ip + ":3000/api/users"

        val json = JSONObject()
        json.put("cpf", this.cpf)

        val (request, response, result) = Fuel.post(url)
            .jsonBody(json.toString())
            .response()
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
        }
        println(result)
        when(result) {
            is Result.Success -> {
                println("Success")
            }
            is Result.Failure -> {
                println("Failure")
            }
        }
    }

    fun update(id: Int){
        println("----UserLink.update----")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString()

        var json = JSONObject()
        //json.put("", this.)

        val (request, response, result) = Fuel.get(url)
            .jsonBody(json.toString())
            .response()
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
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

    fun listDebt(id: Int){
        println("----User.listDebt---")

        val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString() + "/listDebt"
        val (request, response, result) = Fuel.get(url)
            .responseObject(OverdraftDebtLink.ListDeserializer())
        println("Response:" + response)
        val (bytes, error) = result
        print("Bytes: " + bytes)

        if (bytes != null) {
            this.Debt = bytes
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
}