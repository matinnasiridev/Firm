package com.example.firm.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.firm.util.Constants.TableCategory

@Entity(tableName = TableCategory)
data class CategoryData(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    val img: String? = "null",
    val title: String? = "null"
)
