package com.example.accountkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_account_detail.* //이것을 해줌으로써 activity에 연결된 xml파일의 veiw의 id를 변수처럼 사용가능

class AccountDetailActivity : AppCompatActivity() {

    val account by lazy {  intent.extras["Account"] as CheckingAccount }//이름으로 intent 가져오기
                                                    //초기화 한것

    fun reload(){
        //선언이 안되어 있어도  그 activity가 사용하는 xml 파일의 요소들을 자동으로 가져옴
        text_account_number.text = account.accountNumber
        text_balance.text = account.balance.toString()
        text_interest.text = account.interest.toString()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_detail)

        //TO DO YUJIN

        reload()

        bt_deposit.setOnClickListener{ view ->
            val input =  editAmount.text.toString().toIntOrNull()  //input의 타입은 int? 이다.(int 이거나 null)
            //editAmount가 editable형식이므로 더하기 위해 string으로 바꾸었다가 int로 바꾼다.(intOrNull은 문자가 들어갔을때는 null로 설정해주기위함)

            if (input != null) {
                account.deposit(input)
                reload()
            }
            editAmount.text.clear() //deposit할 것 다 하고 text내용을 지우는것 (입력창 text 지우는것)

        }
        bt_withdraw.setOnClickListener { view ->

            val input =  editAmount.text.toString().toIntOrNull()  //input의 타입은 int? 이다.(int 이거나 null)
            //editAmount가 editable형식이므로 더하기 위해 string으로 바꾸었다가 int로 바꾼다.(intOrNull은 문자가 들어갔을때는 null로 설정해주기위함)

            if (input != null) {
                account.withdtaw(input)
                reload()
            }
            editAmount.text.clear()

        }


    }

    override fun onBackPressed() {
        val resultIntent = Intent(this, MainActivity::class.java) //mainActivity로 데이터 보내주기
        resultIntent.putExtra("AccountBack", account)

        setResult(1, resultIntent)

        super.onBackPressed()
    }
}
