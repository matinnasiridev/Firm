package com.example.firm.util

interface RecyclerCallBack<T> {
    fun onClick(note: T)
    fun onLongClick(note: T)
}