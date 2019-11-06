package com.eps.creditoffer

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ListDebtAdapter(private val list: List<OverdraftDebtLink>)
    : RecyclerView.Adapter<DebtViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DebtViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: DebtViewHolder, position: Int) {

        val debt: OverdraftDebtLink = list[position]
        holder.bind(debt)
    }

    override fun getItemCount(): Int = list.size

}

class DebtViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_list_debt_adapter, parent, false)) {
    private var iDateView: TextView = itemView.findViewById(R.id.invoice_due)
    private var iValueView: TextView = itemView.findViewById(R.id.list_value)

    fun bind(debt: OverdraftDebtLink) {
     print("")
        var day: String=""
        if(debt.isDivided) {
            day = "Vencimento dia "+debt.dueDate.toString()
        }else{
             day= "Data por definir."
        }

        iDateView.text = day
        iValueView.text = "R$ " + "%.2f".format(debt.amount)

        // change color test

        if(!debt.isDivided) {
            iValueView.setTextColor(Color.RED)
        }
    }
}