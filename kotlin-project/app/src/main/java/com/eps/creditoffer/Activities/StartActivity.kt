package com.eps.creditoffer.Activities

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eps.creditoffer.Connections.StartLink
import com.eps.creditoffer.Connections.UserLink
import com.eps.creditoffer.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        setContentView(R.layout.activity_start)

        val st = StartLink()

        button_start.setOnClickListener(View.OnClickListener {
            val name = editText_startName.text.toString()

            if (name == "") {
                Toast.makeText(this, "Digite um nome!", Toast.LENGTH_LONG).show()
            } else {
                if (st.start(name)) {
                    UserLink.get(1)

                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    startActivityIfNeeded(intent, 0)
                    finish()
                } else {
                    Toast.makeText(this, "Erro ao iniciar aplicação!", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
