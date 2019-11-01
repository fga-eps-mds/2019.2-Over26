package com.eps.creditoffer

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val list: List<InstalmentModel>)
    : RecyclerView.Adapter<InstalmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstalmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return InstalmentViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: InstalmentViewHolder, position: Int) {
        val instalment: InstalmentModel = list[position]
        holder.bind(instalment)
    }

    override fun getItemCount(): Int = list.size

}

class InstalmentViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var iMonthView: TextView = itemView.findViewById(R.id.list_month)
    private var iDateView: TextView = itemView.findViewById(R.id.list_date)
    private var iValueView: TextView = itemView.findViewById(R.id.list_value)

    fun bind(instalment: InstalmentModel) {
        iMonthView.text = instalment.month
        iDateView.text = instalment.date
        iValueView.text = instalment.value


        // change color test
        if(instalment.month == "Nov") {
            iValueView.setTextColor(Color.RED)
        }
    }
}