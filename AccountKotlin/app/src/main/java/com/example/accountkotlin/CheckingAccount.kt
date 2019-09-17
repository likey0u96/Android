package com.example.accountkotlin

class CheckingAccount(accountNumber: String, balance: Int = 0, interest: Double = 0.00)
    : Account(accountNumber, balance){
    val interest = interest

    fun withdtaw(amount: Int){
        balance -= amount
    }
    fun deposit(amount: Int) : Boolean{
        if(amount < balance){
            balance -= amount
            return true
        }else{
            return false
        }
    }

    override fun aMonthHasPassed() {
        balance = (balance * (1 + interest)).toInt()
    }
}