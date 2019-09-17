package com.example.accountjava;

public class Account {
    public final String accountNumber;
    private int balance;

    public int getBalance(){
        return balance;
    }
    protected void setBalance(int newBalance){
        balance = newBalance;
    }

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(String accountNumber){
//        this.accountNumber = accountNumber;
//        this.balance = 0;     아래와 같다.

        this(accountNumber, 0);
    }
}
