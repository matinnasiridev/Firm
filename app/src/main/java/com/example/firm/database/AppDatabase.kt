package com.example.firm.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.firm.model.*


@Database(entities = [SingleNoteData::class, CategoryData::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
    abstract val categoryDao: CategoryDao
}