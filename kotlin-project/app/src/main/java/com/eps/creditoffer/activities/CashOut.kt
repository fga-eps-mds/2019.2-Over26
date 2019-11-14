package com.eps.creditoffer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.*
import com.eps.creditoffer.connections.OverdraftLink
import com.eps.creditoffer.connections.TransactionLink
import com.eps.creditoffer.models.Account
import com.eps.creditoffer.R
import com.eps.creditoffer.utils.mainAccount
import kotlinx.android.synthetic.main.activity_cash_out.*

class CashOut : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_out)

        val transaction = TransactionLink()
        transaction.type = "out"

        val optionsString = arrayOf("Compra com cartão",
                                    "Pagamento de boleto",
                                    "Transferência")

        cash_out_Spinner.adapter = ArrayAdapter(this,
                                                android.R.layout.simple_spinner_dropdown_item,
                                                optionsString)

        cash_out_Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) { }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                transaction.description = optionsString[position]
            }
        }

        retirarButton.setOnClickListener {
            val stringOfValue = valor.text.toString()
            transaction.value = stringOfValue.toFloat()

            val overdraft = OverdraftLink()
            overdraft.get(1)

            if (transaction.value > mainAccount.balance && overdraft.isActive && transaction.description == "Compra com cartão") {
                if (transaction.value <= 0F || transaction.description == null) {
                    if (transaction.description == null) {
                        Toast.makeText(this, "Escolher forma de retirada.", Toast.LENGTH_LONG).show()
                    }
                    if (transaction.value <= 0F) {
                        Toast.makeText(this, "Valor da retirada precisa ser positivo.", Toast.LENGTH_LONG).show()
                    }
                } else {
                    if (transaction.create()) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            } else if (transaction.value > mainAccount.balance && overdraft.isActive && (transaction.description == "Pagamento de boleto" || transaction.description == "Transferência")) {
                if (transaction.value <= 0F || transaction.description == null) {
                    if (transaction.description == null) {
                        Toast.makeText(this, "Escolher forma de retirada.", Toast.LENGTH_LONG).show()
                    }
                    if (transaction.value <= 0F) {
                        Toast.makeText(this, "Valor da retirada precisa ser positivo.", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "Cheque especial disponível apenas para compra com cartão.", Toast.LENGTH_LONG).show()
                }
            } else if (transaction.value > mainAccount.balance && !overdraft.isActive) {
                if (transaction.value <= 0F || transaction.description == null) {
                    if (transaction.description == null) {
                        Toast.makeText(this, "Escolher forma de retirada.", Toast.LENGTH_LONG).show()
                    }
                    if (transaction.value <= 0F) {
                        Toast.makeText(this, "Valor da retirada precisa ser positivo.", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "Cheque especial desativado.", Toast.LENGTH_LONG).show()
                }
            } else {
                if (transaction.value <= 0F || transaction.description == null) {
                    if (transaction.description == null) {
                        Toast.makeText(this, "Escolher forma de retirada.", Toast.LENGTH_LONG).show()
                    }
                    if (transaction.value <= 0F) {
                        Toast.makeText(this, "Valor da retirada precisa ser positivo.", Toast.LENGTH_LONG).show()
                    }
                } else {
                    if (transaction.create()) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}
