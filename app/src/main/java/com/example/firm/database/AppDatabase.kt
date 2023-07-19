package com.example.firm.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.firm.model.SingleNoteData


@Database(entities = [SingleNoteData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}