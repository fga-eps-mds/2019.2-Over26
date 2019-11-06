package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_eligibility.*

class Eligibility : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eligibility)
        println("----eligibilidade----")

        val overdraft = OverdraftLink()

        eligibility_button.setOnClickListener(View.OnClickListener {
            if(!overdraft.get(1)) {
                overdraft.create(1)
            }
            val intent = Intent(this, OverdraftConfirmation::class.java)
            startActivity(intent)
        })
    }
}

