package com.eps.creditoffer

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val list: List<Instalment>)
    : RecyclerView.Adapter<InstalmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstalmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return InstalmentViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: InstalmentViewHolder, position: Int) {
        val instalment: Instalment = list[position]
        holder.bind(instalment)
    }

    override fun getItemCount(): Int = list.size

}

class InstalmentViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var iMonthView: TextView? = null
    private var iDateView: TextView? = null
    private var iValueView: TextView? = null




    init {
        iMonthView = itemView.findViewById(R.id.list_month)
        iDateView = itemView.findViewById(R.id.list_date)
        iValueView = itemView.findViewById(R.id.list_value)

    }

    fun bind(instalment: Instalment) {
        iMonthView?.text = instalment.month
        iDateView?.text = instalment.date
        iValueView?.text = instalment.value


    }

}