package com.example.accountkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_account_detail.*

class AccountDetailActivity : AppCompatActivity() {

    val account by lazy {  intent.extras["Account"] as CheckingAccount }//이름으로 intent 가져오기
                                                    //초기화 한것

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_detail)

        //TO DO YUJIN

        //선언이 안되어 있어도  그 activity가 사용하는 xml 파일의 요소들을 자동으로 가져옴
        text_account_number.text = account.accountNumber
        text_balance.text = account.balance.toString()
        text_interest.text = account.interest.toString()

    }
}
