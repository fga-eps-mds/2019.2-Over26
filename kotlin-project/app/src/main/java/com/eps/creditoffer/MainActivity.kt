package com.eps.creditoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var debtAdapter: ListDebtAdapter

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

    fun viewDebts(view: View) {
        setContentView(R.layout.fragment_debt)

        val user = UserLink()
        user.listDebt(1)
        val debts = user.debt

        val debtList = findViewById<RecyclerView>(R.id.list_recycler_view_debt)
        debtList.layoutManager = LinearLayoutManager(this)
        debtAdapter = ListDebtAdapter(debts,this)
        debtList.adapter = debtAdapter
        }

    override fun onItemClicked(debts: OverdraftDebtLink) {
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
    }
}