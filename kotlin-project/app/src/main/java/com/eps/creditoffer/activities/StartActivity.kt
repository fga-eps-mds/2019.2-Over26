package com.eps.creditoffer.activities

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eps.creditoffer.connections.AccountLink
import com.eps.creditoffer.connections.UserLink
import com.eps.creditoffer.R
import com.eps.creditoffer.utils.currentUser
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        setContentView(R.layout.activity_start)

        println("----StartActivity.onCreate----")

        button_start.setOnClickListener(View.OnClickListener {
            val name = editText_startName.text.toString()

            if (name == "") {
                Toast.makeText(this, "Digite um nome!", Toast.LENGTH_LONG).show()
            } else {
                if (UserLink.create(name)) {
                    if(AccountLink.create(currentUser.id)){
                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                        startActivityIfNeeded(intent, 0)
                        finish()
                    } else {
                        Toast.makeText(this, "Erro ao criar conta!", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "Erro ao criar usuário!", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
