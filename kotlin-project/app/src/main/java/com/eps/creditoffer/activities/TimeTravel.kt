package com.eps.creditoffer.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.eps.creditoffer.R
import com.eps.creditoffer.utils.currentOverdraft
import com.eps.creditoffer.utils.currentUser
import com.eps.creditoffer.utils.recentDebt

class TimeTravel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_travel)

    }


    fun timeTravel(view: View){

        if (currentOverdraft.isActive && currentOverdraft.limitUsed != 0F) {

            recentDebt.create(currentUser.id)

            Toast.makeText(this, "Data atualizada e divida criada!", Toast.LENGTH_LONG)
                .show()

            finish()

        }else{
            Toast.makeText(
                this,
                "Overdraft não encontrado ou não utilizado!",
                Toast.LENGTH_LONG
            ).show()
        }

    }

}
