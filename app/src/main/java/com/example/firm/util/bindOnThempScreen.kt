package com.example.firm.util

import com.example.firm.databinding.ModuleScreenThempBinding

fun bindOnThempScreen(
    root: ModuleScreenThempBinding,
    img: Int,
    title: Int,
    desc: Int
) {
    root.image.setImageResource(img)
    root.title.setText(title)
    root.desc.setText(desc)
}