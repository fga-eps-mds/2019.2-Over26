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

class OverdraftDebtLink() {

    var entryDate: Date = Date()
    var amount: Float = 0F
    var rate: Float = 0F
    var wasDivided: Boolean = FALSE
    //var installment: <InstallmentsLink>
    var dueDate: Int = 0
    var quantityInstallment: Int = 0
    var totalAmount: Float = 0F

    private val ip: String = "192.168.0.16"

    class Deserializer : ResponseDeserializable<OverdraftDebtLink> {
        override fun deserialize(content: String) = Gson().fromJson(content, OverdraftDebtLink::class.java)
    }

    fun create(id: Int){
        println("----OverdraftDebtLink.create---")
        val url: String = "http://" + ip + ":3000/api/users/" + id.toString() + "/overdraftDebt"

        Fuel.post(url)
            .responseObject(OverdraftDebtLink.Deserializer()) { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    this.entryDate = bytes.entryDate
                    this.amount = bytes.amount
                    this.rate = bytes.rate
                    this.wasDivided = bytes.wasDivided
                    this.dueDate = bytes.dueDate
                    this.quantityInstallment = bytes.quantityInstallment
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

    fun checkAmout(id: Int, r: Installment){
        println("----OverdraftDebtLink.checkAmout---")
        val url: String = "http://" + ip + ":3000/api/overdraftDebts/" + id.toString() + "/check"

        Fuel.get(url)
            .responseObject(OverdraftDebtLink.Deserializer()) { request, response, result ->
                println(request)
                println(response)
                val (bytes, error) = result
                if (bytes != null) {
                    this.totalAmount = bytes.totalAmount
                    println("AAAAAA"+totalAmount)

                    r.callback(this)
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
}