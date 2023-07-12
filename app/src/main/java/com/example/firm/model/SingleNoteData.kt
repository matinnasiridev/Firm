package com.example.firm.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SingleNoteData(
    val id: Int? = 0,

    val title: String,
    val main: String,
    val category: List<Int>? = null,
    val createDate: String,

    val lastUpdateDate: String? = null
) : Parcelable
