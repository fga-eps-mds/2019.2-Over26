package com.eps.creditoffer.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.os.Handler
import android.widget.PopupMenu
import com.eps.creditoffer.Connections.AccountLink
import com.eps.creditoffer.Connections.OverdraftDebtLink
import com.eps.creditoffer.Connections.OverdraftLink
import com.eps.creditoffer.Connections.UserLink
import com.eps.creditoffer.Models.User
import com.eps.creditoffer.Utils.InstalmentFragment
import com.eps.creditoffer.Utils.ListDebtAdapter
import com.eps.creditoffer.Utils.OnItemClickListener
import com.eps.creditoffer.R
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var debtAdapter: ListDebtAdapter
    private var inDebts: Boolean = FALSE
    private var inInstalment: Boolean = FALSE
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val account= AccountLink()

        if(!account.get(1)) {
            account.agency = 1
            account.number=1
            account.create(1)
        }
        else{
            saldo.setText("R$"+account.balance.toString())
        }

        println("----MainActivity.onCreate----")
    }

    override fun onResume() {
        super.onResume()
        println("----MainActivity.onResume----")
    }

    override fun onBackPressed() {
        if (inInstalment) {
            inInstalment = FALSE
            viewDebts(null)
            super.onBackPressed()
            return
        }
        if (inDebts) {
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
        if (User.id != 0) {
            setContentView(R.layout.fragment_debt)
            inDebts = TRUE

            val debts = User.debt
            val debtList = findViewById<RecyclerView>(R.id.list_recycler_view_debt)
            debtList.layoutManager = LinearLayoutManager(this)
            debtAdapter = ListDebtAdapter(debts, this)
            debtList.adapter = debtAdapter
        } else {
            Toast.makeText(this, "Nenhuma dívida encontrada!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onItemClicked(debts: OverdraftDebtLink) {
        println("----MainActivity.onItem----")
        if (debts.isDivided) {
            inInstalment = TRUE
            setContentView(R.layout.fragment_instalment)

            val fm = supportFragmentManager
            var fragmentInstalment = fm.findFragmentById(R.id.fragment_container)
            // ensures fragments already created will not be created
            if (fragmentInstalment == null) {
                fragmentInstalment =
                    InstalmentFragment.newInstance(debts.id)
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

    fun showPopUp(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.cashInMenu -> {
                    val account = AccountLink()
                    if (account.get(1)) {
                        val intent = Intent(this, CashIn::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                        startActivityIfNeeded(intent, 0)
                    } else {
                        Toast.makeText(this, "Conta não encontrada!", Toast.LENGTH_LONG).show()
                    }
                }

                R.id.cashOutMenu -> {
                    val account = AccountLink()
                    if (account.get(1)) {
                        val intent = Intent(this, CashOut::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                        startActivityIfNeeded(intent, 0)
                    } else {
                        Toast.makeText(this, "Conta não encontrada!", Toast.LENGTH_LONG).show()
                    }
                }

                R.id.attDataMenu -> {
                    val overdraft = OverdraftLink()
                    overdraft.get(1)
                    if (overdraft.isActive && overdraft.limitUsed != 0F) {
                        overdraft.createDebt(1)

                        Toast.makeText(this, "Data atualizada e divida criada!", Toast.LENGTH_LONG)
                            .show()

                        val intent = Intent(this, TrackLimit::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                        startActivityIfNeeded(intent, 0)
                    } else {
                        Toast.makeText(
                            this,
                            "Overdraft não encontrado ou não utilizado!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
            true
        }
    }
}