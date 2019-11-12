package com.eps.creditoffer.Utils

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eps.creditoffer.Connections.OverdraftDebtLink
import com.eps.creditoffer.R

class ListDebtAdapter(private val list: List<OverdraftDebtLink>,
                      private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<DebtViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DebtViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: DebtViewHolder, position: Int) {
        val debt: OverdraftDebtLink = list[position]
        holder.bind(debt, itemClickListener)
    }

    override fun getItemCount(): Int = list.size
}

class DebtViewHolder(inflater: LayoutInflater, val parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_list_debt_adapter, parent, false)) {
    private var iDateView: TextView = itemView.findViewById(R.id.invoice_due)
    private var iValueView: TextView = itemView.findViewById(R.id.list_value)
    private var iNumberView: TextView = itemView.findViewById(R.id.amount_of_instalments)

    fun bind(debt: OverdraftDebtLink, clickListener: OnItemClickListener) {
        itemView.setOnClickListener{
            clickListener.onItemClicked(debt)
        }
        iValueView.text = "R$ " + "%.2f".format(debt.checkAmout(debt.id))

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

interface OnItemClickListener{
    fun onItemClicked(debt: OverdraftDebtLink)
}