package com.example.roomtest.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtest.R
import com.example.roomtest.model.NoteModel
import com.example.roomtest.screens.start.StartFragment

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var listNote = emptyList<NoteModel>()

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_title).text = listNote[position].title
    }

    override fun getItemCount(): Int {
       return listNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list:List<NoteModel>){
        listNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickNote(listNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener (null)
    }
}