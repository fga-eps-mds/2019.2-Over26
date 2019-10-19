package com.eps.creditoffer
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.json.JSONObject

class TransactionLink {

    var accountId: Int = 1
    var name: String = ""
    var type: String = ""
    var description : String= ""

    private val ip: String ="10.0.2.2"

    class Deserializer : ResponseDeserializable<TransactionLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, TransactionLink::class.java)
    }


    fun create() : Boolean{
        println("----TrasactionLink.create----")
        val url: String = "http://" + ip + ":3000/api/transactions/"

        val json = JSONObject()
        json.put("accountId", accountId)
        json.put("name", this.name)
        json.put("type", this.type)
        json.put("description", this.description)


        val (request, response, result) =  Fuel.post(url)
            .jsonBody(json.toString())
            .responseObject(TransactionLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.accountId = bytes.accountId
            this.name = bytes.name
            this.type = bytes.type
            this.description = bytes.description
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