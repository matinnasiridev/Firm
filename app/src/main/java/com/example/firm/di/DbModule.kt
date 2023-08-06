package com.example.firm.di

import android.content.Context
import androidx.room.Room
import com.example.firm.database.AppDatabase
import com.example.firm.database.CategoryDao
import com.example.firm.database.NoteDao
import com.example.firm.model.CategoryData
import com.example.firm.model.SingleNoteData
import com.example.firm.util.Constants.DatabaseName
import org.koin.dsl.module

object DbModule {
    val databaseModule = module {

        single { provideDatabase(get()) }

        single { provideNoteDao(get()) }

        single { provideCategoryDao(get()) }

        single { provideNoteEntity() }

        single { provideCategoryEntity() }

    }


    private fun provideDatabase(cnt: Context): AppDatabase {
        return Room.databaseBuilder(
            cnt,
            AppDatabase::class.java,
            DatabaseName
        ).allowMainThreadQueries()
            .build()
    }

    private fun provideNoteDao(db: AppDatabase): NoteDao = db.noteDao


    private fun provideCategoryDao(db: AppDatabase): CategoryDao = db.categoryDao

    private fun provideNoteEntity(): SingleNoteData = SingleNoteData()

    private fun provideCategoryEntity(): CategoryData = CategoryData()
}