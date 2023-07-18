package com.example.firm.repository

import com.example.firm.model.SingleNoteData

class Repository {

    fun createFakeData(): List<SingleNoteData> {

        return listOf(
            SingleNoteData(title = "hellowDady1", main = "cossher", createDate = "now!"),
            SingleNoteData(title = "hellowDady2", main = "cossher", createDate = "now!"),
            SingleNoteData(title = "hellowDady3", main = "cossher", createDate = "now!"),
            SingleNoteData(title = "hellowDady4", main = "cossher", createDate = "now!"),
            SingleNoteData(title = "hellowDady5", main = "cossher", createDate = "now!"),
            SingleNoteData(title = "hellowDady6", main = "cossher", createDate = "now!"),
            SingleNoteData(title = "hellowDady7", main = "cossher", createDate = "now!"),
            SingleNoteData(title = "hellowDady8", main = "cossher", createDate = "now!"),
            SingleNoteData(title = "hellowDady9", main = "cossher", createDate = "now!"),
            SingleNoteData(title = "hellowDady10", main = "cossher", createDate = "now!"),
            SingleNoteData(title = "hellowDady11", main = "cossher", createDate = "now!")
        )


    }
}