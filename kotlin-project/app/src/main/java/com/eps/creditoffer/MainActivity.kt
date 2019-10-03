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

        println("----MainActivity----")
    }

    fun overdraftScreen(view: View) {
        intent = Intent(this, TrackLimit::class.java)
        startActivity(intent)
    }

    fun activeOverdraft(view: View) {
        val intent = Intent(this, eligibilidade::class.java)
        startActivity(intent)
    }
}
