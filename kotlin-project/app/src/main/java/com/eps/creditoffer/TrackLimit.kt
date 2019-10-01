package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.track_limit.*
import android.widget.SeekBar
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import org.json.JSONObject

class TrackLimit : AppCompatActivity() {

    var curLimit: Float = 0F
    var maxLimit: Float = 200F
    var curUsage: Float = 50F
    var cpf: Int = 1234


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.track_limit)

        text_view_usage.setText("R$ " + curUsage.toInt().toString())
        text_view_usage2.setText("R$0,00")
        text_view_cur.setText("R$ " + curLimit.toInt().toString())
        text_view_max.setText("R$ " + maxLimit.toInt().toString())
        seek_bar.max = maxLimit.toInt()

        // Set a SeekBar change listener
        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar

                text_view_cur.text = "R$"+i.toString()
                curLimit = i.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
            }
        })



        val  cancelCredit = findViewById(R.id.cancelCredit) as Button



        cancelCredit.setOnClickListener {

            var url: String = "http://10.0.2.2:3000/api/users/"+ cpf + "/overdrafts/cancel"

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

        val  save = findViewById(R.id.save) as Button
        save.setOnClickListener {

            var url: String = "http://10.0.2.2:3000/api/users/"+ 1 + "/overdrafts"

            val json = JSONObject()
            json.put("limit", curLimit)

            println(curLimit)

            Fuel.put(url).jsonBody(json.toString())
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

        var url: String = "http://10.0.2.2:3000/api/users/"+ 1 + "/overdrafts"

        Fuel.get(url)
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
                        println(result)

                    }
                    is Result.Failure -> {
                        println("Deu ruim")
                    }
                }
            }
    }
    }

