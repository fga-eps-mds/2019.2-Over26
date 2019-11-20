package com.eps.creditoffer.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.eps.creditoffer.connections.OverdraftDebtLink
import com.eps.creditoffer.connections.OverdraftLink
import com.eps.creditoffer.R
import com.eps.creditoffer.utils.currentOverdraft
import com.eps.creditoffer.utils.currentUser
import com.eps.creditoffer.utils.recentDebt
import kotlinx.android.synthetic.main.activity_installment.*
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE

class Installment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_installment)

        recentDebt.get(recentDebt.id)
        recentDebt.checkAmout(recentDebt.id)

        OverdraftLink.get(currentUser.id)

        textView_installment_quant.text = recentDebt.quantityInstalment.toString()
        val value = "%.2f".format(recentDebt.totalAmount / recentDebt.quantityInstalment)
        textView_installment_value.text = "R$ " + value

        button_plus.setOnClickListener(View.OnClickListener {

            if (recentDebt.quantityInstalment >= 1 && recentDebt.quantityInstalment <12) {
                recentDebt.quantityInstalment++
                textView_installment_quant.text = recentDebt.quantityInstalment.toString()
                val value = "%.2f".format(recentDebt.totalAmount / recentDebt.quantityInstalment)
                textView_installment_value.text = "R$ " + value
            }
        })

        button_minus.setOnClickListener(View.OnClickListener {
            if (recentDebt.quantityInstalment> 1 && recentDebt.quantityInstalment <= 12) {
                recentDebt.quantityInstalment--
                textView_installment_quant.text = recentDebt.quantityInstalment.toString()
                val value = "%.2f".format(recentDebt.totalAmount / recentDebt.quantityInstalment)
                textView_installment_value.text = "R$ " + value
            }
        })

        button_day1.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day1.setBackgroundResource(R.drawable.btn_background)
            recentDebt.dueDay = 1
        })

        button_day5.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day5.setBackgroundResource(R.drawable.btn_background)
            recentDebt.dueDay = 5
        })

        button_day10.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day10.setBackgroundResource(R.drawable.btn_background)
            recentDebt.dueDay = 10
        })

        button_day15.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day15.setBackgroundResource(R.drawable.btn_background)
            recentDebt.dueDay = 15
        })

        button_day20.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day20.setBackgroundResource(R.drawable.btn_background)
            recentDebt.dueDay = 20
        })

        button_day25.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day25.setBackgroundResource(R.drawable.btn_background)
            recentDebt.dueDay = 25
        })

        button_confirm_installment.setOnClickListener(View.OnClickListener {
            recentDebt.isDivided = TRUE
            if (recentDebt.createInstallment(currentUser.id)) {
                currentOverdraft.isBlocked = FALSE
                Toast.makeText(this, "Cheque especial liberado!", Toast.LENGTH_LONG).show()
                finish()
            } else {
                recentDebt.isDivided = FALSE
                Toast.makeText(this, "Não foi possível realizar o parcelamento.", Toast.LENGTH_LONG).show()
            }

        })

        button_cancel_installment.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    fun cleanbuttons() {
        button_day1.setBackgroundColor(Color.TRANSPARENT)
        button_day5.setBackgroundColor(Color.TRANSPARENT)
        button_day10.setBackgroundColor(Color.TRANSPARENT)
        button_day15.setBackgroundColor(Color.TRANSPARENT)
        button_day20.setBackgroundColor(Color.TRANSPARENT)
        button_day25.setBackgroundColor(Color.TRANSPARENT)
    }
}