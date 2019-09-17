package com.example.accountkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val accounts = arrayOf(CheckingAccount("123-456-7890", interest = 0.01),
            CheckingAccount( "123-123-1234",1000, interest = 0.02),
            CheckingAccount( "111-111-1111", 1000000) )

        accounts[0].deposit(30000) //예금 30000원 해보기

        var list : ListView =  findViewById(R.id.account_list)
        // var list  =  findViewById<ListView>(R.id.account_list)

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            accounts)

        list.setAdapter(adapter)
        list.adapter = adapter

        list.setOnItemClickListener()
        {parent, itemView, position, id->
            accounts[position].aMonthHasPassed()
            adapter.notifyDataSetChanged()
        }

    }
}
