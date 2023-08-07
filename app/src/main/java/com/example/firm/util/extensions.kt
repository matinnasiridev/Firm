@file:Suppress("DEPRECATION")

package com.example.firm.util

import android.content.Context
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firm.databinding.ModuleScreenThempBinding

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
    isHorizontal: Boolean = false,
    adapter: () -> RecyclerView.Adapter<T>
) {
    this.adapter = adapter()
    this.layoutManager = LinearLayoutManager(
        this.context,
        if (isHorizontal) RecyclerView.HORIZONTAL else RecyclerView.VERTICAL,
        false
    )
}


fun fillThePage(
    root: ModuleScreenThempBinding,
    img: Int,
    title: Int,
    desc: Int
) {
    root.image.setImageResource(img)
    root.title.setText(title)
    root.desc.setText(desc)
}

fun ImageButton.onBack(f: FragmentActivity) {
    this.setOnClickListener {
        f.onBackPressed()
    }
}

