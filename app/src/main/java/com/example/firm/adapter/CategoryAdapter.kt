package com.example.firm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firm.databinding.ItemCategoryBinding
import com.example.firm.model.CategoryData

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {
    private lateinit var binding: ItemCategoryBinding
    private val cList: ArrayList<CategoryData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryHolder()
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(cList[position])
    }

    override fun getItemCount(): Int = cList.size


    inner class CategoryHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(d: CategoryData) {
            binding.apply {
                titleCtg.text = d.title
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submit(new: List<CategoryData>) {
        cList.clear()
        cList.addAll(new)
        notifyDataSetChanged()
    }
}