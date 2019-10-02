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


class TrackLimit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.track_limit)

        val overdraft = OverdraftLink()
        overdraft.post(1)

        showSeekBar(overdraft)

        button_save.setOnClickListener(View.OnClickListener {
            // overdraft update
        })

        button_cancel.setOnClickListener(View.OnClickListener {
            // disable overdraft
        })

        button_installment.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Installment::class.java)
            startActivity(intent)
        })
    }

    fun showSeekBar(overdraft: OverdraftLink){
        if(overdraft.isActive){
            textView_usage.setText("R$ " + overdraft.limitUsed.toInt().toString())
            textView_cur.setText("R$ " + overdraft.limit.toInt().toString())
            textView_max.setText("R$ " + overdraft.limitMax.toInt().toString())
            seek_bar.progress = overdraft.limit.toInt()
            seek_bar.max = overdraft.limitMax.toInt()

            if(!overdraft.isBlocked){

                // Hide installment button
                button_installment.visibility = View.INVISIBLE

                // SeekBar
                textView_currentUsage.text = "Uso Atual"
                textView_usage.setTextColor(Color.BLACK)
                textView_usage.setTypeface(Typeface.DEFAULT)

                // Save button
                button_save.visibility = View.INVISIBLE

                // Set a SeekBar change listener
                seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                    override fun onProgressChanged(seekBar: SeekBar, value: Int, b: Boolean) {
                        // Display the current progress of SeekBar
                        textView_cur.text = "R$"+value.toString()
                        overdraft.limit = value.toFloat()
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar) {

                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar) {
                        button_save.visibility = View.VISIBLE
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
