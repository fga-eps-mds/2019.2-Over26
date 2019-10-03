package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_eligibilidade.*

class eligibilidade : AppCompatActivity() {

    val urlErick: String = "http://192.168.0.16:3000/api/overdrafts"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eligibilidade)
        println("----eligibilidade----")

        val overdraft = OverdraftLink()

        eligibility_button.setOnClickListener(View.OnClickListener {
            overdraft.checkUsability(1, this)
        })
    }
}

