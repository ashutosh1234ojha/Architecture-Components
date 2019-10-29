package com.example.architecturecomponents.mvvm

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.architecturecomponents.mvvm.room.Note


 class NoteViewModel  (application: Application) : AndroidViewModel(application) {

    private var repository: NoteRepository = NoteRepository(application)
     private var allNotes: LiveData<List<Note>>

    init {

        allNotes = repository.getAllNotesFromDb()
    }


    fun insert(note: Note) {

        repository.insert(note)

    }

    fun update(note: Note) {

        repository.update(note)
    }

    fun delete(note: Note) {
        repository.delete(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()


    }

    fun getAllNotesFromDb(): LiveData<List<Note>> {
        return allNotes
    }
}