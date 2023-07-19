package com.example.firm.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.firm.model.SingleNoteData

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: SingleNoteData)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(listNotes: List<SingleNoteData>)


    @Delete
    fun deleteNote(note: SingleNoteData)


    @Query("SELECT * FROM note_table")
    fun getAllNotes(): LiveData<List<SingleNoteData>>

}