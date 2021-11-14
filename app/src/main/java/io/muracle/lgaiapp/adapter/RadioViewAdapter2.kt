package io.muracle.lgaiapp.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.muracle.lgaiapp.adapter.item.CheckItem
import io.muracle.lgaiapp.databinding.ItemButtonRectBinding
import io.muracle.lgaiapp.databinding.ItemButtonSquareBinding
import java.util.*

class RadioViewAdapter2(private val values: ArrayList<CheckItem>, var selectedId: Int, var clickListener: RecyclerClickListener) : RecyclerView.Adapter<RadioViewAdapter2.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemButtonRectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item, position)
    }


    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemButtonRectBinding) : RecyclerView.ViewHolder(binding.root) {
        val root = binding.root
        val text = binding.text

        @SuppressLint("NotifyDataSetChanged")
        fun bind(item: CheckItem, pos:Int){

            text.text = item.name

            itemView.isSelected = selectedId != 0 && selectedId == item.id

            root.setOnClickListener {
                selectedId = item.id
                clickListener!!.onClick(it, pos)
                notifyDataSetChanged()
            }
        }
    }
}