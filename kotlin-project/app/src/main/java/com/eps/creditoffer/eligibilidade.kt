package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.kittinunf.result.Result
import android.widget.Button
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.Fuel
//mport com.github.kittinunf.fuel.android.core.Json
//import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelError



class eligibilidade : AppCompatActivity() {
    val url: String = "10.0.2.2:3000/api/overdrafts"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eligibilidade)
        println("1")

       val eligibility_button = findViewById(R.id.eligibility_button) as Button
        eligibility_button.setOnClickListener {


            url.httpPost().responseString { request, response, result ->
                    when (result) {
                        is Result.Success -> {
                            //val data = result.get()
                            //println(data)
                            val intent = Intent(this, TelaDeConfirmacaoChequeEspecial::class.java)

                        }
                        is Result.Failure -> {
                            println("Deu ruim")
                        }

                    }
                }


        }
        }
    }

