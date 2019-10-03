package com.eps.creditoffer

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_installment.*
import java.lang.Boolean.TRUE

class Installment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_installment)

        var debt = OverdraftDebtLink()
        debt.create(1)
        debt.get(1)
        debt.checkAmout(1, this)

        //callback(debt)


    }

    fun callback(debt: OverdraftDebtLink) {

        textView_installment_quant.text = debt.quantityInstallment.toString()
        val value = "%.2f".format(debt.totalAmount/debt.quantityInstallment)
        textView_installment_value.text = "R$ " + value

        button_plus.setOnClickListener(View.OnClickListener {

            if (debt.quantityInstallment>=1 && debt.quantityInstallment<12) {
                debt.quantityInstallment++
                textView_installment_quant.text = debt.quantityInstallment.toString()
                val value = "%.2f".format(debt.totalAmount/debt.quantityInstallment)
                textView_installment_value.text = "R$ " + value
            }
        })

        button_minus.setOnClickListener(View.OnClickListener {
            if (debt.quantityInstallment>1 && debt.quantityInstallment<=12) {
                debt.quantityInstallment--
                textView_installment_quant.text = debt.quantityInstallment.toString()
                val value = "%.2f".format(debt.totalAmount / debt.quantityInstallment)
                textView_installment_value.text = "R$ " + value
            }
        })

        button_day1.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day1.setBackgroundResource(R.drawable.btn_background)
            debt.dueDate = 1
        })

        button_day5.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day5.setBackgroundResource(R.drawable.btn_background)
            debt.dueDate = 5
        })

        button_day10.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day10.setBackgroundResource(R.drawable.btn_background)
            debt.dueDate = 10
        })

        button_day15.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day15.setBackgroundResource(R.drawable.btn_background)
            debt.dueDate = 15
        })

        button_day20.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day20.setBackgroundResource(R.drawable.btn_background)
            debt.dueDate = 20
        })

        button_day25.setOnClickListener(View.OnClickListener {
            cleanbuttons()
            button_day25.setBackgroundResource(R.drawable.btn_background)
            debt.dueDate = 25
        })

        button_confirm_installment.setOnClickListener(View.OnClickListener {
            debt.wasDivided = TRUE
            debt.split(1)
            val intent = Intent(this, TrackLimit::class.java)
            startActivity(intent)
        })

        button_cancel_installment.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, TrackLimit::class.java)
            startActivity(intent)
        })
    }

    fun cleanbuttons(){
        button_day1.setBackgroundColor(Color.TRANSPARENT)
        button_day5.setBackgroundColor(Color.TRANSPARENT)
        button_day10.setBackgroundColor(Color.TRANSPARENT)
        button_day15.setBackgroundColor(Color.TRANSPARENT)
        button_day20.setBackgroundColor(Color.TRANSPARENT)
        button_day25.setBackgroundColor(Color.TRANSPARENT)
    }

}