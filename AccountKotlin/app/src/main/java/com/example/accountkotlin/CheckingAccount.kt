package com.example.accountkotlin

import android.os.Parcel
import android.os.Parcelable

//이름에서 오른쪽 버튼을 누르고 Generater을 눌러서 pacelable을 누르면 자동으로 필요한 것이 생성된다.
class CheckingAccount(accountNumber: String, balance: Int = 0, interest: Double = 0.00) :
    Account(accountNumber, balance), Parcelable {
    val interest = interest

    fun withdtaw(amount: Int) { //출금
        balance -= amount
    }

    fun deposit(amount: Int): Boolean { //입금
        if (amount < balance) {
            balance += amount
            return true
        } else {
            return false
        }
    }

    override fun aMonthHasPassed() {
        balance = (balance * (1 + interest)).toInt()
    }

    constructor(source: Parcel) : this(
        source.readString(),
        source.readInt(),
        source.readDouble()
    )

    override fun describeContents() = 0


    //소포화 시키는
    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(accountNumber)
        writeInt(balance)
        writeDouble(interest)
    }

    //소포화 된것을 어떻게 checkingAccount를 만들어 낼 것인가
    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CheckingAccount> = object : Parcelable.Creator<CheckingAccount> {
            override fun createFromParcel(source: Parcel): CheckingAccount = CheckingAccount(source)
            override fun newArray(size: Int): Array<CheckingAccount?> = arrayOfNulls(size)
        }
    }
}