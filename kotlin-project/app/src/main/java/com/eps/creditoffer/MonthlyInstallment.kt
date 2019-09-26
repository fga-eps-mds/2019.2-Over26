package com.eps.creditoffer

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MonthlyInstallment : AppCompatActivity(), MyRecyclerViewAdapter.ItemClickListener {

    internal lateinit var adapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monthly_installment)

        // data to populate the RecyclerView with
        val animalNames = ArrayList<String>()
        animalNames.add("Horse")
        animalNames.add("Cow")
        animalNames.add("Camel")
        animalNames.add("Sheep")
        animalNames.add("Goat")

        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvAnimals)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        adapter = MyRecyclerViewAdapter(this, animalNames)
        adapter.setClickListener(this)
        recyclerView.setAdapter(adapter)
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(
            this,
            "You clicked " + adapter.getItem(position) + " on row number " + position,
            Toast.LENGTH_SHORT
        ).show()
    }
}
