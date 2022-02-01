package com.example.roomtest.data.repository

import androidx.lifecycle.LiveData
import com.example.roomtest.model.NoteModel

interface NoteRepository {
    val allNotes : LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel:NoteModel, onSuccess:()->Unit)
    suspend fun deleteNote(noteModel:NoteModel, onSuccess:()->Unit)
}