package com.eps.creditoffer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_instalment.*

class InstalmentFragment : Fragment() {

    val debt = OverdraftDebtLink()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("----MainFragment.onCreate----")
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_instalment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("----MainActivity.onViewCreated----")

        debt.listInstalments(arguments!!.getInt("REPLACE WITH A STRING CONSTANT"))
        val instalments = debt.instalment

        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListInstalmentAdapter(instalments)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val intent = Intent(context, Eligibility::class.java)
        startActivity(intent)
    }

    companion object {
        @JvmStatic
        fun newInstance(isMyInt: Int) = InstalmentFragment().apply {
            arguments = Bundle().apply {
                putInt("REPLACE WITH A STRING CONSTANT", isMyInt)
            }
        }
    }
}