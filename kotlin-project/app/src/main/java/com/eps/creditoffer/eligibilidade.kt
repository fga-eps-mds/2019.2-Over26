package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_eligibilidade.*

class eligibilidade : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eligibilidade)
        println("----eligibilidade----")

        val overdraft = OverdraftLink()

        eligibility_button.setOnClickListener(View.OnClickListener {
            if(overdraft.checkUsability(1)){
                val intent = Intent(this, TelaDeConfirmacaoChequeEspecial::class.java)
                startActivity(intent)
            }
        })
    }
}

