package com.example.roomtest.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomtest.REPOSITORY
import com.example.roomtest.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    fun delete(noteModel: NoteModel, onSucces:()-> Unit){
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.deleteNote(noteModel){
                onSucces()
            }
        }
    }
}