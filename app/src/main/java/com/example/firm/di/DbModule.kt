package com.example.firm.di

import android.content.Context
import androidx.room.Room
import com.example.firm.database.AppDatabase
import com.example.firm.database.NoteDao
import com.example.firm.model.SingleNoteData
import com.example.firm.util.Constants.DatabaseName
import com.example.firm.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DbModule {
    val databaseModule = module {
        single { provideDatabase(get()) }

        single { provideDao(get()) }

        single { provideEntity() }

    }


    private fun provideDatabase(cnt: Context): AppDatabase {
        return Room.databaseBuilder(
            cnt,
            AppDatabase::class.java,
            DatabaseName
        ).allowMainThreadQueries()
            .build()
    }

    private fun provideDao(db: AppDatabase): NoteDao = db.noteDao

    private fun provideEntity(): SingleNoteData = SingleNoteData()
}