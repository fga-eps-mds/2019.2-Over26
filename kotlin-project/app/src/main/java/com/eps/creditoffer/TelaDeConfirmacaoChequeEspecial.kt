package com.eps.creditoffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.content.Intent
import com.github.kittinunf.result.Result
import com.github.kittinunf.fuel.Fuel

class TelaDeConfirmacaoChequeEspecial : AppCompatActivity() {
    val url: String = "http://10.0.2.2:3000/api/overdrafts"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_confirmacao_cheque_especial)

        val  activateOverdraft = findViewById(R.id.activateOverdraft) as Button


        activateOverdraft.setEnabled(false)
        activateOverdraft.setClickable(false)
        val checkBox = findViewById<CheckBox>(R.id.checkBox2)
        checkBox?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                activateOverdraft.setEnabled(true)
                activateOverdraft.setClickable(true)
            }
            else {
                activateOverdraft.setEnabled(false)
                activateOverdraft.setClickable(false)
            }

        activateOverdraft.setOnClickListener {



            Fuel.put(url)
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

                            val intent = Intent(this, TrackLimit::class.java)
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
}
