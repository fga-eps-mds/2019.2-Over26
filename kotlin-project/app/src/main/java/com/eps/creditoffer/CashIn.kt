package com.eps.creditoffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_cash_in.*

class CashIn : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_in)
        val optionsString= arrayOf("","Boleto","Transferencia");
        chashInSpinner.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,optionsString)

    }
}
