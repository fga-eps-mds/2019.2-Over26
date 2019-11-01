package com.eps.creditoffer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private val instalments = listOf(
        InstalmentModel("Out","Vencimento dia 15/10","R$100,00"),
        InstalmentModel("Nov","Vencimento dia 15/11","R$100,00"),
        InstalmentModel("Dez","Vencimento dia 15/12","R$100,00"),
        InstalmentModel("Jan","Vencimento dia 15/01","R$100,00"),
        InstalmentModel("Fev","Vencimento dia 15/02","R$100,00"),
        InstalmentModel("Mar","Vencimento dia 15/03","R$100,00"),
        InstalmentModel("Abr","Vencimento dia 15/04","R$100,00")
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