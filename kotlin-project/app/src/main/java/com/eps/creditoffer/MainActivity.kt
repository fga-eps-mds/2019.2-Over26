package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = UserLink()
        //user.post()
        user.get(1)

        println("---------------------Main 1:")
        println(user.cpf)

        /*Botão auxiliar q será removido posteriormente*/
        val auxiliar = findViewById(R.id.auxiliar) as Button

        auxiliar.setOnClickListener{

            val intent = Intent(this, eligibilidade::class.java)
            // start your next activity
            startActivity(intent)
        }
    }

    fun overdraftScreen(view: View) {
        intent = Intent(this, TrackLimit::class.java)
        startActivity(intent)
    }
}
