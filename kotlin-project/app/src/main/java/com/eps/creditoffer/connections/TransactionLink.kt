package com.eps.creditoffer.connections
import com.eps.creditoffer.BuildConfig
import com.eps.creditoffer.utils.currentAccount
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.json.JSONObject
import java.util.*

class TransactionLink {

    var accountId: Int = 1
    var name: String = ""
    var type: String = ""
    var value: Float = 0F
    var description: String = "Boleto"
    var date: Date = Date()

    private val ip: String =  BuildConfig.BASE_URL

    class Deserializer : ResponseDeserializable<TransactionLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, TransactionLink::class.java)
    }

    fun create(): Boolean {
        println("----TrasactionLink.create----")
        val url: String = "http://" + ip + ":3000/api/transactions/"

        val json = JSONObject()
        json.put("accountId", currentAccount.id)
        json.put("name", this.name)
        json.put("type", this.type)
        json.put("description", this.description)
        json.put("date", this.date)
        json.put("value", this.value)

        val (request, response, result) = Fuel.post(url)
            .jsonBody(json.toString())
            .responseObject(Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.accountId = bytes.accountId
            this.name = bytes.name
            this.type = bytes.type
            this.description = bytes.description
            this.date = bytes.date
            this.value = bytes.value
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

    fun get(id: Int): Boolean {
        println("----TransactionLink.get----")
        val url: String = "http://" + ip + ":3000/api/transactions/" + id.toString()

        val (request, response, result) = Fuel.get(url)
            .responseObject(Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.accountId = bytes.accountId
            this.name = bytes.name
            this.type = bytes.type
            this.description = bytes.description
            this.date = bytes.date
            this.value = bytes.value
        }
        when (result) {
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
}