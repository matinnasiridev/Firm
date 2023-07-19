package com.example.firm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.firm.R
import com.example.firm.databinding.ItemNoteBinding
import com.example.firm.model.SingleNoteData
import com.example.firm.util.RecyclerCallBack


class MainRecyclerAdapter(
    private val api: RecyclerCallBack<SingleNoteData>

) : RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {
    private lateinit var binding: ItemNoteBinding
    private val listData: ArrayList<SingleNoteData> = arrayListOf()

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(noteData: SingleNoteData) {

            binding.apply {
                txtTitle.text = noteData.title
                txtShortDesc.text = noteData.main
                txtTime.text = "Now!"
            }

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
        binding = ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listData[position])
        binding.itemRecycler.startAnimation(
            AnimationUtils.loadAnimation(
                holder.itemView.context,
                R.anim.main_recycler_anim
            )
        )
    }

    override fun getItemCount(): Int = listData.size

    @SuppressLint("NotifyDataSetChanged")
    fun refreshRecycler(new: List<SingleNoteData>?) {
        listData.clear()
        listData.addAll(new!!)
        notifyDataSetChanged()
    }
}