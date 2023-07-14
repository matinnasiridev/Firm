package com.example.firm.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: SingleNoteData)


    @Insert
    fun insertNotes(listNotes: List<SingleNoteData>)


    @Update
    fun updateNote(note: SingleNoteData)


    @Delete
    fun deleteNote(note: SingleNoteData)


    @Query("SELECT * FROM note_table")
    fun getAllNotes(): ArrayList<SingleNoteData>? = null

}