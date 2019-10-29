package com.example.architecturecomponents.mvvm.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "note_table")
 data class Note(var title: String, var description: String, var priority: Int) {
    @PrimaryKey(autoGenerate = true)
     var id: Int = 0
//    private var title: String = ""
//    private var description: String = ""
//    private var priority: Int = 0



}