package com.example.firm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [SingleNoteData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        private var myDatabase: AppDatabase? = null
        suspend fun getDatabase(cnt: Context): AppDatabase {
            if (myDatabase == null) {
                myDatabase = Room.databaseBuilder(
                    cnt,
                    AppDatabase::class.java,
                    "centerDatanase.db"
                ).build()
            }
            return myDatabase!!
        }
    }
}