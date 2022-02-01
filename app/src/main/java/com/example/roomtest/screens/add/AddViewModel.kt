package com.example.roomtest.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomtest.REPOSITORY
import com.example.roomtest.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel : ViewModel() {

    fun insert(noteModel: NoteModel, onSucces:()-> Unit){
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertNote(noteModel){
                onSucces()
            }
        }
    }
}