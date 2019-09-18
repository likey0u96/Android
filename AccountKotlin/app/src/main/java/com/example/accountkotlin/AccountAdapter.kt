package com.example.accountkotlin

import android.content.Context  //어댑터를 만들때는 안에 내용을 받아오는게 제일 중요해서 항상 context도 받아와야함
import android.view.LayoutInflater //view를 만들때는 처음으로 Inflater가 반드시 필요 (이 안에 context를 받아와야함)
                            //view를 부풀려서 만든다고 생각하기
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text


//어댑터 만들기!
class AccountAdapter(val context: Context, val accounts: Array<CheckingAccount>) : BaseAdapter() {
    override fun getCount(): Int { //몇개인지
        return accounts.size
    }

    override fun getItemId(idx: Int): Long { //id가 무엇인지
        return idx.toLong()
        //일단은 index를 returng함 (long 타입을 반환하므로 to.long()을 사용해서 타입캐스팅

    }
    override fun getItem(idx: Int): Any {
        return accounts[idx]
        //idx번째의 accounts를 반환

    }
                                    //재사용 뷰                listView를 말하는 parent
    override fun getView(idx: Int, convertView: View?, parent: ViewGroup?): View {
        //listView의 element를 그리는 뷰를 달라
        //convertView가 넘어오면 그것을 재사용해서 뷰를 뿌리는 것이고 , 안넘어 오면 새로 뷰를만들어서 뿌려야함
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_element_account_linear, parent, false) as View
               //?: null이면 앞에꺼쓰고 아니면 뒤에꺼 써라                         //false :함수 호출하는 쪽에서 붙여줄거임 바로안붙일거임
        view.findViewById<TextView>(R.id.list_account_number_in_list).text = accounts[idx].accountNumber
        view.findViewById<TextView>(R.id.balance_in_list).text = accounts[idx].balance.toString()

        return view
    }
}