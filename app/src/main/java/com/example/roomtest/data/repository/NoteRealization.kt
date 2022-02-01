package com.example.roomtest.data.repository

import androidx.lifecycle.LiveData
import com.example.roomtest.data.dao.NoteDao
import com.example.roomtest.model.NoteModel

class NoteRealization (private val noteDao: NoteDao): NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }
}