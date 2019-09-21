package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.track_limit.*
import android.widget.SeekBar
import android.content.Intent
import com.github.kittinunf.result.Result
import android.widget.Button
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.core.Json
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelError

class TrackLimit : AppCompatActivity() {

    val url: String = "http://10.0.2.2:3000/api/overdrafts"

    var curLimit: Float = 0F
    var maxLimit: Float = 200F
    var curUsage: Float = 50F

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


                Fuel.put(url)
                    .response { request, response, result ->
                        println(request)
                        println(response)
                        val (bytes, error) = result
                        if (bytes != null) {
                            println("[response bytes] ${String(bytes)}")
                        }

                        when(result){
                            is Result.Success -> {
                                Fuel.put(url)
                                    .response { request, response, result ->
                                        println(request)
                                        println(response)
                                        val i = result
                                    }
                            }
                            is Result.Failure -> {
                                println("Não foi possivel atualizar")
                            } }
                    }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //Do something

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
            }
        })

        val url: String = "http://10.0.2.2:3000/api/overdrafts"
        val cancel_overdraft = findViewById(R.id.button2) as Button
        cancel_overdraft.setOnClickListener {


            Fuel.put(url)
                .response { request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("[response bytes] ${String(bytes)}")
                    }
                    when(result){
                        is Result.Success -> {

                            val intent = Intent(this, TrackLimit::class.java)
                            startActivity(intent)

                        }
                        is Result.Failure -> {
                            println("Falha no cancelamento")
                        }
                    }
                }
    }


}
