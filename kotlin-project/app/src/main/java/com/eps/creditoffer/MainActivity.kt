package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Boolean.FALSE
import android.os.Handler
import java.lang.Boolean.TRUE


class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var debtAdapter: ListDebtAdapter
    private var inDebts: Boolean = FALSE
    private var inInstalment: Boolean = FALSE
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("----MainActivity.onCreate----")
    }

    override fun onResume() {
        super.onResume()
        println("----MainActivity.onResume----")
    }

    override fun onBackPressed(){
        if(inInstalment) {
            inInstalment = FALSE
            viewDebts(null)
            super.onBackPressed()
            return
        }
        if(inDebts){
            setContentView(R.layout.activity_main)
            inDebts = FALSE
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed()
                return
            }

            this.doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

            Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
        }
    }

    fun cashOut(view: View) {
        val account = AccountLink()
        if (account.get(1)) {
            val intent = Intent(this, CashOut::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivityIfNeeded(intent, 0)
        } else {
            Toast.makeText(this, "Conta não encontrada!", Toast.LENGTH_LONG).show()
        }
    }

    fun cashIn(view: View) {
        val account = AccountLink()
        if (account.get(1)) {
            val intent = Intent(this, CashIn::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivityIfNeeded(intent, 0)
        } else {
            Toast.makeText(this, "Conta não encontrada!", Toast.LENGTH_LONG).show()
        }
    }

    fun overdraftScreen(view: View) {
        val overdraft = OverdraftLink()
        overdraft.get(1)
        if (overdraft.isActive) {
            val intent = Intent(this, TrackLimit::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivityIfNeeded(intent, 0)
        } else {
            Toast.makeText(this, "Overdraft Desativado!", Toast.LENGTH_LONG).show()
        }
    }

    fun activeOverdraft(view: View) {
        val overdraft = OverdraftLink()
        overdraft.get(1)
        if (overdraft.isActive) {
            Toast.makeText(this, "Overdraft Ativo!", Toast.LENGTH_LONG).show()
        } else {
            val intent = Intent(this, Eligibility::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivityIfNeeded(intent, 0)
        }
    }

    fun viewDebts(view: View?) {
        println("----MainActivity.viewDebts----")
        val user = UserLink()
        if(user.listDebt(1)){
            setContentView(R.layout.fragment_debt)
            inDebts = TRUE

            val debts = user.debt
            val debtList = findViewById<RecyclerView>(R.id.list_recycler_view_debt)
            debtList.layoutManager = LinearLayoutManager(this)
            debtAdapter = ListDebtAdapter(debts,this)
            debtList.adapter = debtAdapter
        } else {
            Toast.makeText(this, "Nenhuma dívida encontrada!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onItemClicked(debts: OverdraftDebtLink) {
        println("----MainActivity.onItem----")
        if(debts.isDivided) {
            inInstalment = TRUE
            setContentView(R.layout.fragment_instalment)

            val fm = supportFragmentManager
            var fragmentInstalment = fm.findFragmentById(R.id.fragment_container)
            // ensures fragments already created will not be created
            if (fragmentInstalment == null) {
                fragmentInstalment = InstalmentFragment.newInstance(debts.id)
                // create and commit a fragment transaction
                fm.beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.fragment_container, fragmentInstalment)
                    .commit()
            }
        } else {
            Toast.makeText(this, "Dívida não parcelada!", Toast.LENGTH_LONG).show()
        }
    }
}