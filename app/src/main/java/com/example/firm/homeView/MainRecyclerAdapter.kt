package com.example.firm.homeView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firm.databinding.ItemSmallNoteBinding
import com.example.firm.model.SingleNoteData


class MainRecyclerAdapter(
    private val listData: List<SingleNoteData>,
    private val api: RecyclerCallBack<SingleNoteData>
) :
    RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {
    private lateinit var binding: ItemSmallNoteBinding

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(noteData: SingleNoteData) {

            binding.titleNote.text = noteData.title


            itemView.setOnClickListener {
                api.onClick(noteData)
            }
            itemView.setOnLongClickListener {
                api.onLongClick(noteData)
                true
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding =
            ItemSmallNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MainViewHolder(
            binding.root

        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

}


interface RecyclerCallBack<T> {
    fun onClick(note: T)
    fun onLongClick(note: T)
}