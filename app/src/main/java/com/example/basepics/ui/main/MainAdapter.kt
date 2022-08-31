package com.example.basepics.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.basepics.databinding.ItemPicsRvBinding
import com.example.basepics.extension.load
import com.example.basepics.model.Image

import kotlin.collections.ArrayList


class MainAdapter:
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var list = arrayListOf<Image>()
    val selectedList = ArrayList<String>()

    inner class ViewHolder(private var binding: ItemPicsRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: Image) = with(binding) {
            imageviewPics.load(image.image)
            itemView.setOnClickListener {
                if (image.bool) {
                    image.bool = false
                    background.isVisible = true
                    selectedList.add(image.image)
                } else {
                    image.bool = true
                    background.isVisible = false
                    selectedList.remove(image.image)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPicsRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: ArrayList<Image>) {
        this.list = list
        notifyDataSetChanged()
    }

}


