package com.example.firm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.firm.model.CategoryData
import com.example.firm.model.SingleNoteData
import com.example.firm.repository.Repository

class MainViewModel(
    private val rps: Repository
) : ViewModel() {

    fun getAllNotes(): LiveData<List<SingleNoteData>> = rps.getList()

    fun insertNote(note: SingleNoteData) = rps.insertNote(note)

    fun insertNote(listNote: List<SingleNoteData>) = rps.insertNote(listNote)

    fun deleteItem(note: SingleNoteData) = rps.deleteItem(note)

    // Category
    fun filterCategory(c: String): LiveData<List<SingleNoteData>> = rps.getListByName(c)
    // -->

    // Test Tools
    fun fillFirst() = insertNote(rps.create())

}

