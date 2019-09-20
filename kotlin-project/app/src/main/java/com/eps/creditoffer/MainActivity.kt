package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        /*Botão auxiliar q será removido posteriormente*/
        val auxiliar = findViewById(R.id.auxiliar) as Button

        auxiliar.setOnClickListener{

            val intent = Intent(this, eligibilidade::class.java)
            // start your next activity
            startActivity(intent)
        }

        }
    }

