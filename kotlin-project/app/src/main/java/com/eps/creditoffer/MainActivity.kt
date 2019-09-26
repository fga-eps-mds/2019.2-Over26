package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun mudarTela(view: View) {
        Toast.makeText(this, "Show some text on the screen.", Toast.LENGTH_LONG).show();

        val intent = Intent(this,MonthlyInstallment::class.java)
        startActivity(intent)

    }

}

