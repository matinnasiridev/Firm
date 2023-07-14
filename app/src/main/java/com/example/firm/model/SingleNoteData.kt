package com.example.firm.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "note_table")
@Parcelize
data class SingleNoteData(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    val title: String,
    val main: String,
    val createDate: String,

    val lastUpdateDate: String? = null
) : Parcelable
