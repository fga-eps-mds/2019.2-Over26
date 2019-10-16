package com.eps.creditoffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_cash_out.*

class CashOut : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_out)

        val optionsString= arrayOf("","Compra com cartão", "Pagamento de boleto", "Transferência");
        cash_out_Spinner.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,optionsString)
    }
}
