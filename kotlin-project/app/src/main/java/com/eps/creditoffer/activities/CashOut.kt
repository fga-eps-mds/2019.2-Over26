package com.eps.creditoffer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.eps.creditoffer.connections.OverdraftLink
import com.eps.creditoffer.connections.TransactionLink
import com.eps.creditoffer.R
import com.eps.creditoffer.utils.currentAccount
import com.eps.creditoffer.utils.currentOverdraft
import com.eps.creditoffer.utils.currentUser
import com.eps.creditoffer.utils.recentDebt
import kotlinx.android.synthetic.main.activity_cash_out.*

class CashOut : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_out)

        OverdraftLink.get(currentUser.id)
        recentDebt.get(recentDebt.id)
        val transaction = TransactionLink()
        transaction.type = "out"

        val optionsString = arrayOf(
            "Compra com cartão",
            "Pagamento de boleto",
            "Transferência"
        )

        cash_out_Spinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            optionsString
        )

        cash_out_Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                transaction.description = optionsString[position]
            }
        }

        retirarButton.setOnClickListener {
            val stringOfValue = valor.text.toString()
            val valueRead: Float? = stringOfValue.toFloatOrNull()

            if (valueRead == null) {
                Toast.makeText(this, "Valor inválido.", Toast.LENGTH_LONG)
                    .show()
            } else {
                transaction.value = stringOfValue.toFloat()
                if (valueRead <= 0F) {
                    Toast.makeText(
                        this,
                        "Valor da retirada precisa ser positivo.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    if (currentAccount.balance >= valueRead) {
                        transaction.value = valueRead
                        if (transaction.create()) {
                            Toast.makeText(
                                this,
                                "Transação realizada.",
                                Toast.LENGTH_LONG
                            ).show()
                            finish()
                        } else {
                            Toast.makeText(
                                this,
                                "Erro na transação.",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        if (transaction.description == "Compra com cartão") {
                            if (!currentOverdraft.isActive) {
                                Toast.makeText(
                                    this,
                                    "Cheque especial desativado.",
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                if (currentOverdraft.limit - currentOverdraft.limitUsed >= valueRead) {
                                    transaction.value = valueRead
                                    if (transaction.create()) {
                                        Toast.makeText(
                                            this,
                                            "Cheque especial utilizado!",
                                            Toast.LENGTH_LONG
                                        ).show()
                                        finish()
                                    } else {
                                        Toast.makeText(
                                            this,
                                            "Erro na transação.",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                } else {
                                    Toast.makeText(
                                        this,
                                        "Valor superior ao limite disponivel para o Cheque Especial",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                        } else {
                            Toast.makeText(
                                this,
                                "Não contém saldo! \nUtilize a opção \"Compra com cartão\"",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }
}