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
import java.lang.Boolean.TRUE


class TrackLimit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.track_limit)

        val overdraft = OverdraftLink()
        //overdraft.create(1)

        overdraft.get(1)

        initSeekBar(overdraft)

        button_installment.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Installment::class.java)
            startActivity(intent)
        })

        cancelCredit.setOnClickListener(View.OnClickListener {
            overdraft.cancel(1)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

        save.setOnClickListener(View.OnClickListener {
            overdraft.save(1)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }

    fun initSeekBar(overdraft: OverdraftLink){
        val usage = 30

        if(overdraft.isActive){
            textView_usage.text = "R$ " + usage
            textView_cur.text = "R$ " + overdraft.limit.toInt()
            textView_max.text = "R$ " + overdraft.limitMax.toInt()
            seek_bar.progress = overdraft.limit.toInt()
            seek_bar.max = overdraft.limitMax.toInt()
            seek_bar.isEnabled = TRUE

            println("AAAAAAAAAAAAAAAAAA")

            if(overdraft.isBlocked == FALSE){

                // Hide installment button
                button_installment.visibility = View.INVISIBLE

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

                //Stop seekBar
                seek_bar.isEnabled = FALSE

                textView_currentUsage.text = "TOTAL A SER PAGO"
                textView_cur.text = "-"
                textView_usage.setTextColor(Color.RED)
            }
        }
        else {}//mudar tela

    }
}
