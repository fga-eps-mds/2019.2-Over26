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
    var cpf: Int = 1234
    val url: String = "http://10.0.2.2:3000/api/users/"+ cpf + "/overdrafts"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eligibilidade)
        println("2")

        val eligibility_button = findViewById(R.id.eligibility_button) as Button
        eligibility_button.setOnClickListener {

            //To skip the eligibility verification
       // val intent = Intent(this, TelaDeConfirmacaoChequeEspecial::class.java)
         //   startActivity(intent)



            Fuel.post(url)
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

                            val intent = Intent(this, TelaDeConfirmacaoChequeEspecial::class.java)
                            startActivity(intent)

                        }
                        is Result.Failure -> {
                        println("Deu ruim")
                        }
                    }
                }









        }
        }
    }

