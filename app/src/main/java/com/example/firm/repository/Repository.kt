package com.example.firm.repository

import androidx.lifecycle.LiveData
import com.example.firm.database.CategoryDao
import com.example.firm.database.NoteDao
import com.example.firm.model.SingleNoteData

class Repository(
    private val noteDao: NoteDao,
    private val categoryDao: CategoryDao
) {

    // Local
    fun getList(): LiveData<List<SingleNoteData>> = noteDao.getAllNotes()

    fun getListByName(s: String): LiveData<List<SingleNoteData>> = noteDao.getListByName(s)


    fun getListByID(i: Long): SingleNoteData = noteDao.getListByID(i)

    fun insertNote(note: SingleNoteData) = noteDao.insertNote(note)

    fun insertNote(listNote: List<SingleNoteData>) = noteDao.insertNotes(listNote)

    fun deleteItem(id: Long) = noteDao.deleteNote(id)
    // --->
}