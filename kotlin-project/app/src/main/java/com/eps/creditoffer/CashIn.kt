package com.eps.creditoffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.content.Intent
import android.os.StrictMode
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cash_in.*

class CashIn : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_in)

        var transaction = TransactionLink()
        transaction.type="in"


        val optionsString= arrayOf("Boleto","Transferencia");
        chashInSpinner.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,optionsString)

        chashInSpinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                transaction.description=optionsString[position]
            }
        }






        val depositButton = findViewById(R.id.DepositButton) as Button

        depositButton.setOnClickListener{
            if (transaction.value <= 0F  || transaction.description == null) {

                if(transaction.description == null){
                    Toast.makeText(this, "Escolher forma de depósito.", Toast.LENGTH_LONG).show()
                }

                if(transaction.value <= 0F){
                    Toast.makeText(this, "Valor do depósito precisa ser positivo.", Toast.LENGTH_LONG).show()
                }




            } else {
                transaction.create()
            }

        }

    }

   /* fun makeTransaction(view: View){

        var transaction = TransactionLink()
        transaction.type="in"

        if (transaction.value <= 0F  || transaction.description == null) {

            if(transaction.description == null){
                Toast.makeText(this, "Escolher forma de depósito.", Toast.LENGTH_LONG).show()
            }

            if(transaction.value <= 0F){
            Toast.makeText(this, "Valor do depósito precisa ser positivo.", Toast.LENGTH_LONG).show()
            }




        } else {
            transaction.create()
        }

    }*/

}
