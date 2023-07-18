package com.example.firm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firm.model.SingleNoteData

class HomeViewModel : ViewModel() {

    fun getAllData(): LiveData<List<SingleNoteData>> {
        return MutableLiveData()
    }
}