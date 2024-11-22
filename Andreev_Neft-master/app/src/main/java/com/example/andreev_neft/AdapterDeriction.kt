package com.example.dimabakief_neft

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andreev_neft.R

class AdapterDeriction(
    private var DirectionList: List<Direction>,
    private val onPostClick: (Direction) -> Unit):
    RecyclerView.Adapter<AdapterDeriction.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNumDirectio = itemView.findViewById<TextView>(R.id.tvNumDirectio)
        val tvNameDirectio = itemView.findViewById<TextView>(R.id.tvNameDirectio)

        fun bind(direction: Direction) {
            tvNumDirectio.text = direction.code
            tvNameDirectio.text = direction.name
            itemView.setOnClickListener { onPostClick(direction) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDeriction.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_directio, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterDeriction.ViewHolder, position: Int) = holder.bind(DirectionList[position])

    override fun getItemCount(): Int = DirectionList.size

}