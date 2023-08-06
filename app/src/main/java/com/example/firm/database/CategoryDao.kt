package com.example.firm.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.firm.model.CategoryData
import com.example.firm.util.Constants.TableCategory

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(d: CategoryData)

    @Query("SELECT * FROM $TableCategory")
    fun getAll(): List<CategoryData>

    @Query("SELECT * FROM $TableCategory WHERE id LIKE :i")
    fun getByID(i: Long): CategoryData
}

