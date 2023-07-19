package com.example.firm.viewModel

import androidx.lifecycle.ViewModel
import com.example.firm.database.NoteDao
import com.example.firm.model.SingleNoteData

class HomeViewModel(
    private val noteDao: NoteDao
) : ViewModel() {

    fun getList(): List<SingleNoteData> = noteDao.getAllNotes()

    fun insertNote(note: SingleNoteData) = noteDao.insertNote(note)

    fun insertNote(list: List<SingleNoteData>) = noteDao.insertNotes(list)

    fun deleteItem(note: SingleNoteData) = noteDao.deleteNote(note)
}