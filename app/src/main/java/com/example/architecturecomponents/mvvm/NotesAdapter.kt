package com.androidarchitecturecomponents.room.init.flow

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.architecturecomponents.R
import com.example.architecturecomponents.mvvm.room.Note

/**
 * Created by Ashutosh Ojha on 4/19/19.
 */
class NotesAdapter : RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {

     var list: List<Note>?=null
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MyViewHolder {


        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_notes, viewGroup, false)
        return MyViewHolder(view)
    }

    fun setData(list: List<Note>) {
        this.list = list
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return list?.size ?:0
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, p1: Int) {
        myViewHolder.tvDesc.text = list?.get(p1)?.description
        myViewHolder.tvTitle.text = list?.get(p1)?.title
        myViewHolder.tvPriority.text = list?.get(p1)?.priority.toString()

    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvDesc = view.findViewById<TextView>(R.id.tvDesc)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvPriority = view.findViewById<TextView>(R.id.tvPriority)


    }
}