package com.example.search_city

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.item.view.*

class Adapter( var context: Context, var imageModelArrayList: ArrayList<City>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    lateinit var viewModel: ViewModel
    private val arraylist: ArrayList<City> = ArrayList<City>()
    var userIds = mutableListOf<String>()

    init {
        arraylist.addAll(MainActivity.movieNamesArrayList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.city.text = imageModelArrayList[position].getCity()
        holder.itemView.checkBox.setOnClickListener(View.OnClickListener {
            if (holder.itemView.checkBox.isChecked) {
                Toast.makeText(context, "checked", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "uncheck", Toast.LENGTH_LONG).show()
            }
        })
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var city: TextView = itemView.findViewById(R.id.txtCity) as TextView

    }

}