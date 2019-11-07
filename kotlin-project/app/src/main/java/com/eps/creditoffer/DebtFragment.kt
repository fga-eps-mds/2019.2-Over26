package com.eps.creditoffer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_debt.*

class DebtFragment : Fragment() {

    val user = UserLink()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_debt, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user.listDebt(1)
        val debts = user.debt
        
        list_recycler_view_debt.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListDebtAdapter(debts)
        }
    }
    companion object {

        fun newInstance(): DebtFragment = DebtFragment()
    }
}