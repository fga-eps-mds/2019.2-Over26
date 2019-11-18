package com.eps.creditoffer.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eps.creditoffer.connections.OverdraftDebtLink
import com.eps.creditoffer.R
import kotlinx.android.synthetic.main.fragment_instalment.*

class InstalmentFragment : Fragment() {

    val debt = OverdraftDebtLink()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("----InstalmentFragment.onCreate----")
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("----InstalmentFragment.onCreatedView----")
        return inflater.inflate(R.layout.fragment_instalment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("----InstalmentFragment.onViewCreated----")

        debt.listInstalments(arguments!!.getInt("DebtId"))
        val instalments = debt.instalment

        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListInstalmentAdapter(instalments)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(isMyInt: Int) = InstalmentFragment().apply {
            arguments = Bundle().apply {
                putInt("DebtId", isMyInt)
            }
        }
    }
}