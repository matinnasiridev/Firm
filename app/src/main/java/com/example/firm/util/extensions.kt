package com.example.firm.util

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun Context.showToast(message: String, isShortTime: Boolean = true) {
    Toast.makeText(
        this,
        message,
        if (isShortTime) {
            Toast.LENGTH_SHORT
        } else {
            Toast.LENGTH_LONG
        }
    ).show()
}

fun <T : RecyclerView.ViewHolder> RecyclerView.setAdapter(
    adapter: () -> RecyclerView.Adapter<T>
) {
    this.adapter = adapter()
    this.layoutManager = LinearLayoutManager(this.context)
}

