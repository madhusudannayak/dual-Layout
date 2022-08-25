package com.example.multisuportscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CustomListAdapter(private val onItemClick: OnItemClick) :
    ListAdapter<DataModel, RecyclerView.ViewHolder>(
        object : DiffUtil.ItemCallback<DataModel>() {
            override fun areItemsTheSame(
                oldItem: DataModel,
                newItem: DataModel
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: DataModel,
                newItem: DataModel
            ): Boolean = oldItem == newItem
        }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        )


    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let {
            (holder as ItemViewHolder).apply {
                bindView(it)
            }
        }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.name)
        private val address: TextView = itemView.findViewById(R.id.address)
        private val userLayout: ConstraintLayout = itemView.findViewById(R.id.userLayout)


        fun bindView(data: DataModel) {
            name.text = data.title
            address.text = data.count
            userLayout.setOnClickListener {
                onItemClick.onItemClick(data)
            }

        }
    }

    interface OnItemClick {
        fun onItemClick(item: DataModel)
    }
}