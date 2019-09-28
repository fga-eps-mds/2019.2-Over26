package com.eps.creditoffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_installment.*

class Installment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_installment)

        button_plus.setOnClickListener(View.OnClickListener {
            // disable overdraft
        })
    }

}