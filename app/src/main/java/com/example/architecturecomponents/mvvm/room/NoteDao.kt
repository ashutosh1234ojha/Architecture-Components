package com.example.architecturecomponents.mvvm.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.Dao

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
     fun update(note: Note)

    @Delete
     fun delete(note: Note)

    @Query("DELETE from note_table")
      fun deleteAllNotes()

    @Query("SELECT * from note_table ORDER BY priority DESC")
    fun getAllNotes(): LiveData<List<Note>>
}