package com.example.basepics.ui.pics

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basepics.databinding.ItemPicsRvBinding
import com.example.basepics.extension.load

class PicsAdapter : RecyclerView.Adapter<PicsAdapter.ViewHolder>() {

    private var list = ArrayList<String>()

    inner class ViewHolder(private val binding: ItemPicsRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            binding.imageviewPics.load(image)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(image: ArrayList<String>) {
        this.list = image
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPicsRvBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}