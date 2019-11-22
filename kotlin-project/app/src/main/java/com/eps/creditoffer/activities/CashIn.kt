package com.eps.creditoffer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.eps.creditoffer.connections.TransactionLink
import com.eps.creditoffer.R
import kotlinx.android.synthetic.main.activity_cash_in.*

class CashIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_in)

        val transaction = TransactionLink()
        transaction.type = "in"

        val textValue = findViewById<EditText>(R.id.textValue)

        val optionsString = arrayOf("Boleto", "Transferência")
        cashInSpinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, optionsString)

        cashInSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                transaction.description = optionsString[position]
            }
        }
        val depositButton = findViewById<Button>(R.id.DepositButton)

        depositButton.setOnClickListener {

            val stringOfValue = textValue.text.toString()

            val valueRead: Float? = stringOfValue.toFloatOrNull()

            if (valueRead == null) {
                Toast.makeText(this, "Valor inválido.", Toast.LENGTH_LONG)
                    .show()
            } else {

                transaction.value = stringOfValue.toFloat()

                if (transaction.value <= 0F || transaction.description == "") {

                    if (transaction.description == "") {
                        Toast.makeText(this, "Escolher forma de depósito.", Toast.LENGTH_LONG)
                            .show()
                    }
                    if (transaction.value <= 0F) {
                        Toast.makeText(
                            this,
                            "Valor do depósito precisa ser positivo.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    if (transaction.create()) {
                        Toast.makeText(
                            this,
                            "Transação realizada.",
                            Toast.LENGTH_LONG
                        ).show()
                        finish()
                    }
                }
            }
        }
    }
}