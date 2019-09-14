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
    var maxLimit: Float = 200F
    var curUsage: Float = 50F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view_usage.setText("R$ " + curUsage.toInt().toString())
        text_view_usage2.setText("R$0,00")
        text_view_cur.setText("R$ " + curLimit.toInt().toString())
        text_view_max.setText("R$ " + maxLimit.toInt().toString())
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

                text_view_cur.text = "R$"+i.toString()
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
