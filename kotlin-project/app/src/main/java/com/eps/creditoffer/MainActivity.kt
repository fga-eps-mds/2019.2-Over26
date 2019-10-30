package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("----MainActivity.onCreate----")
    }

    override fun onResume() {
        super.onResume()
        println("----MainActivity.onResume----")
    }

    fun cashOut(view: View) {
        val intent = Intent(this, CashOut::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivityIfNeeded(intent, 0)
    }

    fun cashIn(view: View){
        val account=AccountLink()
        if(account.get(1)){
            val intent = Intent(this, CashIn::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivityIfNeeded(intent, 0)
        }
        else{
            Toast.makeText(this, "Conta não encontrada!", Toast.LENGTH_LONG).show()
        }
    }

    fun overdraftScreen(view: View) {
        val overdraft = OverdraftLink()
        overdraft.get(1)
        if(overdraft.isActive) {
            val intent = Intent(this, TrackLimit::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivityIfNeeded(intent, 0)
        }
        else {
            Toast.makeText(this, "Overdraft Desativado!", Toast.LENGTH_LONG).show()
        }
    }

    fun activeOverdraft(view: View) {
        val overdraft = OverdraftLink()
        overdraft.get(1)
        if(overdraft.isActive) {
            Toast.makeText(this, "Overdraft Ativo!", Toast.LENGTH_LONG).show()
        }
        else {
            val intent = Intent(this, Eligibility::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivityIfNeeded(intent, 0)
        }
    }
}
