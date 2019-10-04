package com.eps.creditoffer

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.track_limit.*
import android.widget.SeekBar
import java.lang.Boolean.FALSE
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Boolean.TRUE


class TrackLimit : AppCompatActivity() {

    val overdraft = OverdraftLink()
    val debt = OverdraftDebtLink()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.track_limit)

        overdraft.get(1)
        debt.create(1)
        debt.checkAmout(1)

        initSeekBar(overdraft, debt)

        println("----TrackLimit.onCreate----")

        button_installment.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Installment::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivityIfNeeded(intent, 0)
        })

        cancelCredit.setOnClickListener(View.OnClickListener {
            println("----cancelCreditButton----")
            if(overdraft.isBlocked || (overdraft.checkUsability(1) == FALSE)){ // dependendo de isBlocked no banco
                Toast.makeText(this,
                    "Parcele a dívida antes de fazer alterações no cheque especial",
                    Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, "Cheque especial Cancelado!", Toast.LENGTH_LONG).show()
                overdraft.cancel(1)
                finish()
            }
        })

        save.setOnClickListener(View.OnClickListener {
            println("----saveButton----")
            overdraft.save(1)
            finish()
        })

    }

    override fun onResume() {
        super.onResume()
        println("----TrackLimit.onResume----")
        initSeekBar(overdraft, debt)

    }

    fun initSeekBar( overdraft: OverdraftLink, debt: OverdraftDebtLink){
        println("----initSeekBar----")

        textView_usage.text = "R$ " + overdraft.limitUsed.toInt()
        textView_cur.text = "R$ "+ overdraft.limit.toInt()
        textView_max.text = "R$ " + overdraft.limitMax.toInt()
        seek_bar.max = overdraft.limitMax.toInt()
        seek_bar.progress = overdraft.limit.toInt()
        seek_bar.isEnabled = TRUE

        if(overdraft.isBlocked == FALSE){

            // Hide installment button
            button_installment.visibility = View.INVISIBLE

            // Hide warning text
            textView_warning.visibility = View.INVISIBLE

            // SeekBar
            textView_currentUsage.text = "Uso Atual"
            textView_usage.setTextColor(Color.BLACK)
            textView_usage.setTypeface(Typeface.DEFAULT)

            // Save button
            save.visibility = View.INVISIBLE

            // Set a SeekBar change listener
            seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                    // Display the current progress of SeekBar
                    textView_cur.text = "R$"+i.toString()
                    overdraft.limit = i.toFloat()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    save.visibility = View.VISIBLE
                }
            })
        }
        else{
            // Show installment button
            button_installment.visibility = View.VISIBLE

            // Shown warning text
            textView_warning.visibility = View.VISIBLE

            // Hide save button
            save.visibility = View.INVISIBLE

            //Stop seekBar
            seek_bar.isEnabled = FALSE
            seek_bar.progress = 0

            textView_usage.text = "%.2f".format(debt.totalAmount)

            textView_currentUsage.text = "TOTAL A SER PAGO"
            textView_cur.text = "-"
            textView_usage.setTextColor(Color.RED)
        }
    }

}
