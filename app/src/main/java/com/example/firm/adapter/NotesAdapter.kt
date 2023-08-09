package com.example.firm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firm.databinding.ItemNoteBinding
import com.example.firm.model.SingleNoteData
import com.example.firm.util.RecyclerCallBack


class NotesAdapter(
    private val api: RecyclerCallBack

) : RecyclerView.Adapter<NotesAdapter.MainViewHolder>() {
    private lateinit var binding: ItemNoteBinding
    private val listData: ArrayList<SingleNoteData> = arrayListOf()

    inner class MainViewHolder : RecyclerView.ViewHolder(binding.root) {
        fun bind(noteData: SingleNoteData) {

            binding.apply {
                tvTitle.text = noteData.title
                tvDetail.text = noteData.main
                tvDate.text = noteData.lastUpdateDate
            }

            // OnClick
            itemView.setOnClickListener {
                api.onClick(noteData.id!!)
            }

            // OnLongClick
            itemView.setOnLongClickListener {
                api.onLongClick(noteData.id!!)
                true
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        binding = ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    @SuppressLint("NotifyDataSetChanged")
    fun submit(new: List<SingleNoteData>) {
        if (new != listData) {
            listData.clear()
            listData.addAll(ArrayList(new))
            notifyDataSetChanged()

        }
    }
}