package com.example.architecturecomponents.mvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.androidarchitecturecomponents.room.init.flow.NotesAdapter
import com.example.architecturecomponents.R
import com.example.architecturecomponents.mvvm.room.Note
import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val notesAdapter = NotesAdapter()


            noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
            rv_notes.adapter = notesAdapter
            rv_notes.layoutManager = LinearLayoutManager(applicationContext)

            noteViewModel.insert(Note("One", "MyStringOne", 1))
            noteViewModel.insert(Note("Two", "MyStringTwo", 2))
            noteViewModel.insert(Note("Three", "MyStringThree", 3))

            noteViewModel.getAllNotesFromDb().observe(this, Observer<List<Note>> {
                notesAdapter.setData(it!!)
            })






    }
}