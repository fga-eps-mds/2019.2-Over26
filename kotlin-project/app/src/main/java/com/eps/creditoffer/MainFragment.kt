package com.eps.creditoffer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

data class Instalment(val month: String, val date: String, val value: String)

class MainFragment : Fragment() {

    private val instalments = listOf(
       Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),
        Instalment("Oct","Vencimento dia 15/08","R$100,00"),


        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(instalments)
        }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}