package com.example.kotlinsqlite.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinsqlite.R
import com.example.kotlinsqlite.model.Person
import kotlinx.android.synthetic.main.item_person.view.*


class PersonAdapter(private val context: Context, private var personList: List<Person>? = null):
    RecyclerView.Adapter<PersonAdapter.PersonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false)
        return PersonHolder(view)
    }

    override fun getItemCount(): Int = personList!!.size

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        val person = personList!![position]
        holder.tvId.text = person.id.toString()
        holder.tvName.text = person.name
        holder.tvEmail.text = person.email
    }

    fun setPersonList(personList: List<Person>) {
        this.personList = personList
        notifyDataSetChanged()
    }

    class PersonHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvId = itemView.tv_id
        val tvName = itemView.tv_name
        val tvEmail = itemView.tv_email
    }

}