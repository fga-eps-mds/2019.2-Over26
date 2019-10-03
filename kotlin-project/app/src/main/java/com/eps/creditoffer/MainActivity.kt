package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Button
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        setContentView(R.layout.activity_main)

        val user = UserLink()
        //user.cpf = 1
        //user.create()
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
