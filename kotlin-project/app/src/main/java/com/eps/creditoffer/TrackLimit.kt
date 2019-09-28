package com.eps.creditoffer

import android.graphics.Color
import android.graphics.ColorSpace
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.track_limit.*
import android.widget.SeekBar
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE
import android.R.attr.button
import android.content.Intent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class TrackLimit : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.track_limit)

        val overdraft = Overdraft(UserId = 1)
        showSeekBar(overdraft)

        button_save.setOnClickListener(View.OnClickListener {
            // overdraft update
        })

        button_cancel.setOnClickListener(View.OnClickListener {
            // disable overdraft
        })

        button_installment.setOnClickListener(View.OnClickListener {
            startActionMode(Intent(this, ))
        })


    }

    fun showSeekBar(overdraft: Overdraft){
        if(overdraft.isActive){
            text_view_usage.setText("R$ " + overdraft.limitUsed.toInt().toString())
            text_view_cur.setText("R$ " + overdraft.limit.toInt().toString())
            text_view_max.setText("R$ " + overdraft.limitMax.toInt().toString())
            seek_bar.progress = overdraft.limit.toInt()
            seek_bar.max = overdraft.limitMax.toInt()

            if(!overdraft.isBlocked){

                // Hide installment button
                button_installment.visibility = View.INVISIBLE

                // SeekBar
                textView_currentUsage.text = "Uso Atual"
                text_view_usage.setTextColor(Color.BLACK)
                text_view_usage.setTypeface(Typeface.DEFAULT)

                // Set a SeekBar change listener
                seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                    override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                        // Display the current progress of SeekBar
                        text_view_cur.text = "R$"+i.toString()
                        overdraft.limit = i.toFloat()
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar) {
                        // Do something
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar) {
                        // Do something
                    }
                })
            }
            else{
                // Show installment button
                button_installment.visibility = View.VISIBLE

                //Stop seekBar
                seek_bar.isEnabled = FALSE

                textView_currentUsage.text = "TOTAL A SER PAGO"
                text_view_cur.text = "-"
                text_view_usage.setTextColor(Color.RED)
                text_view_usage.setTypeface(Typeface.DEFAULT_BOLD)

            }
        }
        else {}//mudar tela


    }

}
