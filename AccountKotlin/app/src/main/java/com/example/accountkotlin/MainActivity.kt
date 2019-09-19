package com.example.accountkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val accounts = arrayOf(CheckingAccount("123-456-7890", interest = 0.01),
        CheckingAccount( "123-123-1234",1000, interest = 0.02),
        CheckingAccount( "111-111-1111", 1000000) )

    var position : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        accounts[0].deposit(30000) //예금 30000원 해보기

        var list : ListView =  findViewById(R.id.account_list)
        // var list  =  findViewById<ListView>(R.id.account_list)



        var adapter = AccountAdapter(this, accounts)

        list.setAdapter(adapter)
        list.adapter = adapter

        list.setOnItemClickListener() {parent, itemView, position, id->

            this.position = position

            val detailIntent = Intent(this, AccountDetailActivity::class.java) //현제 activity에서 정보를 만듦(this)
                                                                    //자바 가상머신에 해당하는 클래스 -> java호환되게 써야하므로 알아두기
            detailIntent.putExtra("Account", accounts[position]) //객체를 intent에 넣어서 넘기다
            startActivityForResult(detailIntent, 1) //결과적으로 넘기는 것
            accounts[position].aMonthHasPassed()
            println("$position" + accounts[position])
            adapter.notifyDataSetChanged()

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(data != null) {
            val account = data.extras["AccountBack"] as CheckingAccount


            if (position != null) {
                accounts[position!!] = account //!! 이건 if문 지나오면 null이 아니라는걸 알려주는것
                (account_list.adapter as BaseAdapter).notifyDataSetChanged() //main에 돌아와서도 적용되도록 하는 코드
            }
        }

    }
}
