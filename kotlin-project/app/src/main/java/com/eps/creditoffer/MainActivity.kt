package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Toast
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = UserLink()
        println(user.get(1))
        if(!user.get(1)) {

            user.cpf = 1
            user.create()
        }
        val account=AccountLink()
        if(!account.get(1))
        {
            account.agency = 1
            account.number=1
            account.create(1)
        }else{
            saldo.setText("R$"+account.balance.toString())
        }

        println("----MainActivity.onCreate----")
    }

    override fun onResume() {
        super.onResume()
        println("----MainActivity.onResume----")
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

    fun showPopUp(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.cashInMenu -> {
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

                R.id.cashOutMenu -> {
                    val account=AccountLink()
                    if(account.get(1)){
                        val intent = Intent(this, CashOut::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                        startActivityIfNeeded(intent, 0)
                    }
                    else{
                        Toast.makeText(this, "Conta não encontrada!", Toast.LENGTH_LONG).show()

                    }

                }

                R.id.attDataMenu -> {
                    val overdraft = OverdraftLink()
                    overdraft.get(1)
                    if(overdraft.isActive && overdraft.limitUsed != 0F) {
                        overdraft.createDebt(1)

                        Toast.makeText(this, "Data atualizada e divida criada!", Toast.LENGTH_LONG).show()

                        val intent = Intent(this, TrackLimit::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                        startActivityIfNeeded(intent, 0)
                    }
                    else {
                        Toast.makeText(this, "Overdraft não encontrado!", Toast.LENGTH_LONG).show()
                    }

                }
            }
            true
        }
    }

}
