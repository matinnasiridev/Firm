package com.example.firm.util

interface RecyclerCallBack<T> {
    fun onClick(noteID: Long)
    fun onLongClick(note: T)
}