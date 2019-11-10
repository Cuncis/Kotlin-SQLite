package com.example.kotlinsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinsqlite.adapter.PersonAdapter
import com.example.kotlinsqlite.db.DbHelper
import com.example.kotlinsqlite.model.Person
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var dbHelper: DbHelper
    lateinit var personList: List<Person>
    lateinit var adapter: PersonAdapter
    lateinit var person: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        person = Person()

        dbHelper = DbHelper(this)
        personList = ArrayList()
        adapter = PersonAdapter(this)

        refreshData()

        initListener()
    }

    private fun initListener() {
        btn_add.setOnClickListener {

            val id = et_id.text.toString().toInt()
            val name = et_name.text.toString()
            val email =  et_email.text.toString()

            person.id = id
            person.name = name
            person.email = email

            dbHelper.addPerson(person)
            refreshData()
        }

        btn_update.setOnClickListener {
            val id = et_id.text.toString().toInt()
            val name = et_name.text.toString()
            val email =  et_email.text.toString()

            person.id = id
            person.name = name
            person.email = email

            dbHelper.updatePerson(person)
            refreshData()
        }

        btn_delete.setOnClickListener {
            val id = et_id.text.toString().toInt()
            val name = et_name.text.toString()
            val email =  et_email.text.toString()

            person.id = id
            person.name = name
            person.email = email

            dbHelper.deletePerson(person)
            refreshData()
        }
    }

    private fun refreshData() {
        rv_personList.layoutManager = LinearLayoutManager(this)
        rv_personList.setHasFixedSize(true)
        personList = dbHelper.allPerson
        adapter.setPersonList(personList)
        rv_personList.adapter = adapter
    }
}










