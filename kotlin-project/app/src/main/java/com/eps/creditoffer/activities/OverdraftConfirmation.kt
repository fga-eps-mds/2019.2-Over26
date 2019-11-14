package com.eps.creditoffer.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import com.eps.creditoffer.connections.OverdraftLink
import com.eps.creditoffer.R
import com.eps.creditoffer.utils.currentUser
import kotlinx.android.synthetic.main.activity_overdraft_confirmation.*

class OverdraftConfirmation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overdraft_confirmation)

        activateOverdraft.setEnabled(false)
        activateOverdraft.setClickable(false)
        val checkBox = findViewById<CheckBox>(R.id.checkBox2)
            checkBox?.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    activateOverdraft.setEnabled(true)
                    activateOverdraft.setClickable(true)
                } else {
                    activateOverdraft.setEnabled(false)
                    activateOverdraft.setClickable(false)
                }

            activateOverdraft.setOnClickListener {
                if (OverdraftLink.activate(currentUser.id)) {
                    finish()
                }
            }
        }
    }
}
