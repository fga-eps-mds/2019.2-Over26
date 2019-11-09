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
        OverdraftDebtLink(Date(120, 2, 6),128f,1,0,false),
        OverdraftDebtLink(Date(120, 2, 6),158f,2,1,true),
        OverdraftDebtLink(Date(120, 2, 6),230f,5,5,true),
        OverdraftDebtLink(Date(120, 2, 6),198f,12,5,true),
        OverdraftDebtLink(Date(120, 2, 6),985f,8,10,true),
        OverdraftDebtLink(Date(120, 2, 6),123f,8,15,true),
        OverdraftDebtLink(Date(120, 2, 6),159f,9,20,true),
        OverdraftDebtLink(Date(120, 2, 6),987f,6,25,true),
        OverdraftDebtLink(Date(120, 2, 6),159f,2,30,true)
        //OverdraftDebtLink(Date(120, 2, 6),953f,4,5,true),
        //OverdraftDebtLink(Date(120, 2, 6),1035f,1,1,true)

        //  InstalmentLink(FALSE, 100F, Date(120, 2, 6))


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_debt, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(debts)
        list_recycler_view_debt.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListDebtAdapter(debts)
        }
    }
    companion object {

        fun newInstance(): DebtFragment = DebtFragment()
    }
}