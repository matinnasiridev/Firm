package com.example.firm.model

import android.os.Parcelable
import com.example.firm.util.FragmentEvent
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventBounds(
    val getEvent: () -> FragmentEvent
) : Parcelable