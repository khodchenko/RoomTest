package com.example.roomtest.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomtest.REPOSITORY
import com.example.roomtest.data.NoteDataBase
import com.example.roomtest.data.repository.NoteRealization
import com.example.roomtest.model.NoteModel


class StartViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    fun innitDataBase() {
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}