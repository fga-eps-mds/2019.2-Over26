package com.eps.creditoffer

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListDebtAdapter(private val list: List<OverdraftDebtLink>) :
    RecyclerView.Adapter<DebtViewHolder>() {

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
    private var iNumberView: TextView = itemView.findViewById(R.id.amount_of_instalments)

    fun bind(debt: OverdraftDebtLink) {
        iValueView.text = "R$ " + "%.2f".format(debt.amount)

        println(debt.quantityInstalment)
        if (!debt.isDivided) {
            iValueView.setTextColor(Color.RED)
            iNumberView.text = "Não parcelado"
            iDateView.text = "Data à definir"
        } else {
            iNumberView.text = "Total de parcelas: " + debt.quantityInstalment.toString()
            iDateView.text = "Vencimento dia " + debt.dueDay.toString()
        }
    }
}