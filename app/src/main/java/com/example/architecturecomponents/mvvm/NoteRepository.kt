package com.example.architecturecomponents.mvvm

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.architecturecomponents.mvvm.room.NoteDao
import com.example.architecturecomponents.mvvm.room.Note
import com.example.architecturecomponents.mvvm.room.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRepository(application: Application) {
    var noteDao: NoteDao
    var allNotes: LiveData<List<Note>>


    init {
        noteDao = NoteDatabase.getInstance(application).noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note) {

//        CoroutineScope(Dispatchers.Main).launch {
            noteDao.insert(note)
//        }

    }

    fun update(note: Note) {

//        CoroutineScope(Dispatchers.Main).launch {
            noteDao.update(note)
//        }
    }

    fun delete(note: Note) {
//        CoroutineScope(Dispatchers.Main).launch {
            noteDao.delete(note)
//        }
    }

    fun deleteAllNotes():Unit {
//        CoroutineScope(Dispatchers.Main).launch {
            noteDao.deleteAllNotes()
//        }


    }

    fun getAllNotesFromDb(): LiveData<List<Note>> {
        return allNotes
    }


}