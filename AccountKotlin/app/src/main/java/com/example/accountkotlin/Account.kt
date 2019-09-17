package com.example.accountkotlin

import java.lang.NullPointerException

abstract class Account(accountNumber: String, balance: Int = 0) {
    val accountNumber  = accountNumber   //생성자에 있는 string 타입을 가져오므로 :string을 생략
    var balance = balance
        protected set(newBalance){
            println("${balance} -> ${newBalance}")
            field = newBalance
        }

    override fun toString() : String{
        return "${accountNumber} : ${balance} "
    }

    abstract fun aMonthHasPassed()
}