package com.example.accountkotlin

import android.content.Intent
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

        var adapter = AccountAdapter(this, accounts)

        list.setAdapter(adapter)
        list.adapter = adapter

        list.setOnItemClickListener() {parent, itemView, position, id->
            val detailIntent = Intent(this, AccountDetailActivity::class.java) //현제 activity에서 정보를 만듦(this)
                                                                    //자바 가상머신에 해당하는 클래스 -> java호환되게 써야하므로 알아두기
            detailIntent.putExtra("Account", accounts[position]) //객체를 intent에 넣어서 넘기다
            startActivityForResult(detailIntent, 1) //결과적으로 넘기는 것
            accounts[position].aMonthHasPassed()
            println("$position" + accounts[position])
            adapter.notifyDataSetChanged()

        }

    }
}
