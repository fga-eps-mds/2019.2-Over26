package com.eps.creditoffer.connections

import com.eps.creditoffer.models.Overdraft
import com.eps.creditoffer.utils.recentDebt
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
    var id: Int = 0
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
            .responseObject(Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.id = bytes.id
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

    fun create(id: Int): Boolean {//overdraft's createDebt controller
        println("----OverdraftDebtLink.create---")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdrafts/createDebt"

        val (request, response, result) = Fuel.post(url)
            .responseObject(Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            recentDebt.id=bytes.id
            recentDebt.entryDate = bytes.entryDate
            recentDebt.amount = bytes.amount
            recentDebt.rate = bytes.rate
            recentDebt.isDivided = bytes.isDivided
            recentDebt.dueDay = bytes.dueDay
            recentDebt.quantityInstalment = bytes.quantityInstalment
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

    fun checkAmout(id: Int) : Float {
        println("----OverdraftDebtLink.checkAmout---")
        val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString() + "/check"

        val (request, response, result) = Fuel.get(url)
            .responseObject(Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
            this.totalAmount = bytes.totalAmount
        }
        when (result) {
            is Result.Success -> {
                println("Success")
                return totalAmount;
            }
            is Result.Failure -> {
                println("Failure")
                return 0f;
            }
        }
    }

    fun createInstallment(id: Int): Boolean{
        println("----OverdraftLinkDebt.createInstallment----")
        val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString() + "/instalments"

        val json = JSONObject()
        json.put("isDivided", this.isDivided)
        json.put("day", this.dueDay)
        json.put("quantityInstalment", this.quantityInstalment)

        val (request, response, result) = Fuel.post(url)
            .jsonBody(json.toString())
            .responseObject(Overdraft.Deserializer())
        println("Response:" + response)
        val (bytes, error) = result
        if (bytes != null) {
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