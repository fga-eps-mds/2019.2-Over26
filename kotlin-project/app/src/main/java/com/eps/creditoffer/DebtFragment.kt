package com.eps.creditoffer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_debt.*
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE
import java.time.LocalDate
import java.util.*

class DebtFragment : Fragment() {

    private val debts = listOf(
        OverdraftDebtLink(),
        OverdraftDebtLink(),
        OverdraftDebtLink(),
        OverdraftDebtLink()
      //  InstalmentLink(FALSE, 100F, Date(120, 2, 6))


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_debt, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000")
        super.onViewCreated(view, savedInstanceState)
        println(debts)
        println("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111")
        list_recycler_view_debt.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListDebtAdapter(debts)
            println("222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222")
        }
    }
    companion object {

        fun newInstance(): DebtFragment = DebtFragment()
    }
}