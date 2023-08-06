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

    fun insertNote(note: SingleNoteData) = noteDao.insertNote(note)

    fun insertNote(listNote: List<SingleNoteData>) = noteDao.insertNotes(listNote)

    fun deleteItem(note: SingleNoteData) = noteDao.deleteNote(note)
    // --->

    // Api


    // --->

    // Tools
    fun create(): List<SingleNoteData> {
        return listOf(
            SingleNoteData(title = "Dady1", main = "Body 1"),
            SingleNoteData(title = "Dady2", main = "Body 2"),
            SingleNoteData(title = "Dady3", main = "Body 3"),
            SingleNoteData(title = "Dady4", main = "Body 4"),
            SingleNoteData(title = "Dady5", main = "Body 5"),
            SingleNoteData(title = "Dady6", main = "Body 6"),
            SingleNoteData(title = "Dady7", main = "Body 7"),
            SingleNoteData(title = "Dady8", main = "Body 8"),
            SingleNoteData(title = "Dady9", main = "Body 9"),
            SingleNoteData(title = "Dady2", main = "Body 2"),
            SingleNoteData(title = "Dady3", main = "Body 3"),
            SingleNoteData(title = "Dady4", main = "Body 4"),
            SingleNoteData(title = "Dady5", main = "Body 5"),
            SingleNoteData(title = "Dady6", main = "Body 6"),
            SingleNoteData(title = "Dady7", main = "Body 7"),
            SingleNoteData(title = "Dady8", main = "Body 8"),
            SingleNoteData(title = "Dady9", main = "Body 9"),
            SingleNoteData(title = "Dady6", main = "Body 6"),
            SingleNoteData(title = "Dady7", main = "Body 7"),
            SingleNoteData(title = "Dady8", main = "Body 8"),
            SingleNoteData(title = "Dady9", main = "Body 9"),
            SingleNoteData(title = "Dady2", main = "Body 2"),
            SingleNoteData(title = "Dady3", main = "Body 3"),
            SingleNoteData(title = "Dady4", main = "Body 4"),
            SingleNoteData(title = "Dady5", main = "Body 5"),
            SingleNoteData(title = "Dady6", main = "Body 6"),
            SingleNoteData(title = "Dady7", main = "Body 7"),
            SingleNoteData(title = "Dady8", main = "Body 8"),
            SingleNoteData(title = "Dady9", main = "Body 9")
        )
    }

}