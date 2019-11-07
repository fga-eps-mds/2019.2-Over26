package com.eps.creditoffer

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.Reader
import java.lang.Boolean.FALSE
import java.util.*

class OverdraftDebtLink {
    var isDivided: Boolean = FALSE
    var dueDay: Int = 0
    var quantityInstalment: Int = 1
    var amount: Float = 0F
    var entryDate: Date = Date()
    var rate: Float = 0F
    var instalment: List<InstalmentLink> = emptyList()
    var totalAmount: Float = 0F

    private val ip: String = "10.0.2.2"

    class Deserializer : ResponseDeserializable<OverdraftDebtLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, OverdraftDebtLink::class.java)
    }
    class ListDeserializer : ResponseDeserializable<List<OverdraftDebtLink>> {
        override fun deserialize(reader: Reader): List<OverdraftDebtLink> {
            val type = object : TypeToken<List<OverdraftDebtLink>>() {}.type
            return Gson().fromJson(reader, type)
        }
    }

    fun get(id: Int): Boolean {
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
            this.isDivided = bytes.isDivided
            this.dueDay = bytes.dueDay
            this.quantityInstalment = bytes.quantityInstalment
            this.instalment = bytes.instalment
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

    fun create(id: Int) {
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
            this.isDivided = bytes.isDivided
            this.dueDay = bytes.dueDay
            this.quantityInstalment = bytes.quantityInstalment
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

    fun checkAmout(id: Int) {
        println("----OverdraftDebtLink.checkAmout---")
        val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString() + "/check"

        val (request, response, result) = Fuel.get(url)
            .responseObject(OverdraftDebtLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.totalAmount = bytes.totalAmount
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

    fun createInstallment(id: Int) {
        println("----OverdraftLinkDebt.createInstallment----")
        val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString() + "/instalments"

        val json = JSONObject()
        json.put("isDivided", this.isDivided)
        json.put("day", this.dueDay)
        json.put("quantityInstalment", this.quantityInstalment)

        val (request, response, result) = Fuel.post(url)
            .jsonBody(json.toString())
            .responseObject(OverdraftLink.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
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

    fun listInstalments(id: Int) {
        println("----OverdraftDebtLink.listInstalments---")
        val url: String = "http://" + ip + ":3000/api/overdraftDebt/" + id.toString() + "/listInstalments"

        val (request, response, result) = Fuel.get(url)
            .responseObject(InstalmentLink.ListDeserializer())
        println("Response:" + response)
        val (bytes, error) = result
        print("Bytes: " + bytes)

        if (bytes != null) {
            this.instalment = bytes
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
}