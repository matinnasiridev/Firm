package com.example.firm.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.firm.util.Constants.TableNote
import kotlinx.parcelize.Parcelize

@Entity(tableName = TableNote)
@Parcelize
data class SingleNoteData(

    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    val title: String? = "",
    val main: String? = "",
    val createDate: String? = "",

    val lastUpdateDate: String? = ""
) : Parcelable
