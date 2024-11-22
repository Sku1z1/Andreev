package com.example.dimabakief_neft

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andreev_neft.R

class AdapterWorkers(
    private var GuideList: List<Workers>,
    private val onPostClick: (Workers) -> Unit):
    RecyclerView.Adapter<AdapterWorkers.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFullName = itemView.findViewById<TextView>(R.id.tvFullName)
        val tvPost = itemView.findViewById<TextView>(R.id.tvPost)
        val tvTeachingSubjects = itemView.findViewById<TextView>(R.id.tvTeachingSubjects)


            fun bind(workers: Workers) {
                tvFullName.text = workers.fullName
                tvPost.text = workers.position
                tvTeachingSubjects.text = workers.teachingSubjects
                itemView.setOnClickListener { onPostClick(workers) }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterWorkers.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_guide, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: AdapterWorkers.ViewHolder, position: Int) = holder.bind(GuideList[position])

        override fun getItemCount(): Int = GuideList.size

    }