package com.eps.creditoffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.SeekBar
import com.marcinmoskala.arcseekbar.ArcSeekBar
import com.marcinmoskala.arcseekbar.ProgressListener
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    var curLimit: Float = 0F
    var maxLimit: Float = 200F *100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view_cur.setText(String.format("%.2f", curLimit))
        text_view_max.setText(String.format("%.2f", maxLimit/100))
        seek_bar.max = maxLimit.toInt()

        //Log.d(arc_bar.onProgressChangedListener.toString())

        //arc_bar.maxProgress = 200
        //val progressListener: ProgressListener// = { progress -> Log.i("SeekBar", "Value is $progress") }
        //progressListener.invoke(0)
        //arc_bar.onProgressChangedListener = progressListener




        // Set a SeekBar change listener
        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                //var cur: Float = i.toFloat()/100

                text_view_cur.text = String.format("%.2f", i.toFloat()/100);
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
            }
        })
    }
}
