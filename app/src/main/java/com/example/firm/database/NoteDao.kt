package com.example.firm.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.firm.model.SingleNoteData
import com.example.firm.util.Constants.TableNote

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: SingleNoteData)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(listNotes: List<SingleNoteData>)


    @Query("DELETE FROM $TableNote WHERE id LIKE :id")
    fun deleteNote(id: Long)


    @Query("SELECT * FROM $TableNote")
    fun getAllNotes(): LiveData<List<SingleNoteData>>


    @Query("SELECT * FROM $TableNote WHERE title LIKE '%' || :name || '%'")
    fun getListByName(name: String): LiveData<List<SingleNoteData>>


    @Query("SELECT * FROM $TableNote WHERE id LIKE '%' || :id || '%'")
    fun getListByID(id: Long): SingleNoteData

}