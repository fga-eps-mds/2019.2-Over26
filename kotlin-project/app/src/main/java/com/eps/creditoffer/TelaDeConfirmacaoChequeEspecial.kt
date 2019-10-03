package com.eps.creditoffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_tela_de_confirmacao_cheque_especial.*

class TelaDeConfirmacaoChequeEspecial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_confirmacao_cheque_especial)

        val overdraft = OverdraftLink()

        activateOverdraft.setEnabled(false)
        activateOverdraft.setClickable(false)
        val checkBox = findViewById<CheckBox>(R.id.checkBox2)
            checkBox?.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    activateOverdraft.setEnabled(true)
                    activateOverdraft.setClickable(true)
                }
                else {
                    activateOverdraft.setEnabled(false)
                    activateOverdraft.setClickable(false)
                }

            activateOverdraft.setOnClickListener {
                overdraft.activate(1, this)
            }
        }
    }
}
