package com.eps.creditoffer.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.eps.creditoffer.connections.OverdraftLink
import com.eps.creditoffer.R
import com.eps.creditoffer.utils.currentUser
import kotlinx.android.synthetic.main.activity_eligibility.*

class Eligibility : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eligibility)
        println("----eligibilidade----")

        val overdraft = OverdraftLink()

        eligibility_button.setOnClickListener(View.OnClickListener {
            if (!overdraft.get(currentUser.id)) {
                overdraft.create(currentUser.id)
            }
            val intent = Intent(this, OverdraftConfirmation::class.java)
            startActivity(intent)
        })
    }
}
