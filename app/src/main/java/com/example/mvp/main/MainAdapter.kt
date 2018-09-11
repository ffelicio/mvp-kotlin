package com.example.mvp.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp.R
import kotlinx.android.synthetic.main.view_main_item.view.*

class MainAdapter(private val items: List<String>, private val listener: (String) -> Unit) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.view_main_item, parent, false)
        return MainViewHolder(viewHolder, listener)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MainViewHolder(itemView: View, private val listener: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: String) {
            itemView.textview.text = item
            itemView.textview.setOnClickListener { listener(item) }
        }
    }
}