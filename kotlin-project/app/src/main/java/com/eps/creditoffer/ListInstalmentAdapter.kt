package com.eps.creditoffer

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ListInstalmentAdapter(private val list: List<InstalmentLink>)
    : RecyclerView.Adapter<InstalmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstalmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return InstalmentViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: InstalmentViewHolder, position: Int) {
        val instalment: InstalmentLink = list[position]
        holder.bind(instalment)
    }

    override fun getItemCount(): Int = list.size
}

class InstalmentViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_instalment, parent, false)) {
    private var iMonthView: TextView = itemView.findViewById(R.id.list_month)
    private var iDateView: TextView = itemView.findViewById(R.id.list_date)
    private var iValueView: TextView = itemView.findViewById(R.id.list_value)

    fun bind(instalment: InstalmentLink) {
        val month: Int = instalment.dueDate.month + 1
        val monthString: String
        when (month) {
            1 -> monthString = "Jan"
            2 -> monthString = "Fev"
            3 -> monthString = "Mar"
            4 -> monthString = "Abr"
            5 -> monthString = "Mai"
            6 -> monthString = "Jun"
            7 -> monthString = "Jul"
            8 -> monthString = "Ago"
            9 -> monthString = "Set"
            10 -> monthString = "Out"
            11 -> monthString = "Nov"
            12 -> monthString = "Dez"
            else -> monthString = "Invalid month"
        }

        val date: String =  "Vencimento dia " +
                            instalment.dueDate.toString().substring(8,10) + "/" +
                            month.toString().padStart(2, '0') + "/" +
                            instalment.dueDate.toString().substring(32)

        iMonthView.text = monthString
        iDateView.text = date
        iValueView.text = "R$ " + "%.2f".format(instalment.value)

        if(!instalment.isPaid) {
            iValueView.setTextColor(Color.DKGRAY)
        }
        if(!instalment.isPaid && instalment.dueDate.month == Date().month) {
            iValueView.setTextColor(Color.RED)
        }
    }
}