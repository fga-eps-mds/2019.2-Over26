package com.eps.creditoffer

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import org.json.JSONObject
import java.lang.Boolean.FALSE
import java.util.*

class OverdraftDebtLink {

    var entryDate: Date = Date()
    var amount: Float = 0F
    var rate: Float = 0F
    var wasDivided: Boolean = FALSE
    var instalment: List<InstalmentModel> = emptyList()
    var dueDate: Int = 0
    var quantityInstallment: Int = 1
    var totalAmount: Float = 0F

    //private val ip: String = "192.168.0.16"
    private val ip: String = "10.0.2.2"

    class Deserializer : ResponseDeserializable<OverdraftDebtLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, OverdraftDebtLink::class.java)
    }

    fun get(id: Int){
        println("----OverdraftDebtLink.get----")
        val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString()

        val (request, response, result) = Fuel.get(url)
            .responseObject(OverdraftDebtLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.entryDate = bytes.entryDate
            this.amount = bytes.amount
            this.rate = bytes.rate
            this.wasDivided = bytes.wasDivided
            this.dueDate = bytes.dueDate
            this.quantityInstallment = bytes.quantityInstallment
            this.instalment = bytes.instalment
        }
        when (result) {
            is Result.Success -> {
                println("Success")
            }
            is Result.Failure -> {
                println("Failure")
            }
        }
    }

    fun create(id: Int){
        println("----OverdraftDebtLink.create---")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdraftDebt"

        val (request, response, result) = Fuel.post(url)
            .responseObject(OverdraftDebtLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.entryDate = bytes.entryDate
            this.amount = bytes.amount
            this.rate = bytes.rate
            this.wasDivided = bytes.wasDivided
            this.dueDate = bytes.dueDate
            this.quantityInstallment = bytes.quantityInstallment
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

    fun checkAmout(id: Int){
        println("----OverdraftDebtLink.checkAmout---")
        val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString() + "/check"

        val (request, response, result) = Fuel.get(url)
            .responseObject(OverdraftDebtLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.totalAmount = bytes.totalAmount
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

    fun createInstallment(id: Int){
        println("----OverdraftLinkDebt.createInstallment----")
        val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString() + "/instalments"

        val json = JSONObject()
        json.put("wasDivided",this.wasDivided)
        json.put("day",this.dueDate)
        json.put("quantityInstalment",this.quantityInstallment)

        val (request, response, result) = Fuel.post(url)
            .jsonBody(json.toString())
            .responseObject(OverdraftLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
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