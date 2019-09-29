package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.kittinunf.result.Result
import android.widget.Button
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody


class eligibilidade : AppCompatActivity() {
    val url: String = "http://10.0.2.2:3000/api/overdrafts"

    val urlErick: String = "http://192.168.0.16:3000/api/overdrafts"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eligibilidade)
        println("2")

        val eligibility_button = findViewById(R.id.eligibility_button) as Button
        eligibility_button.setOnClickListener {

        }

        Fuel.post(urlErick)
//            .jsonBody("{" +
//                    "\"userCPF\": 1234," +
//                    "\"agency\": 1234," +
//                    "\"number\": 1234," +
//                    "\"balance\": 1" +
//                    "}")
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

