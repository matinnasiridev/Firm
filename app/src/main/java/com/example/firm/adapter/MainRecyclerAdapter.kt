package com.example.firm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firm.databinding.ItemSmallNoteBinding
import com.example.firm.model.SingleNoteData
import com.example.firm.util.RecyclerCallBack


class MainRecyclerAdapter(
    private val api: RecyclerCallBack<SingleNoteData>

) : RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {
    private lateinit var binding: ItemSmallNoteBinding
    private val listData: ArrayList<SingleNoteData> = arrayListOf()

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(noteData: SingleNoteData) {

            binding.titleNote.text = noteData.title

            // OnClick
            itemView.setOnClickListener {
                api.onClick(noteData)
            }

            // OnLongClick
            itemView.setOnLongClickListener {
                api.onLongClick(noteData)
                true
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        binding = ItemSmallNoteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    @SuppressLint("NotifyDataSetChanged")
    fun refreshRecycler(new: List<SingleNoteData>?) {
        listData.clear()
        listData.addAll(new!!)
        notifyDataSetChanged()
    }
}