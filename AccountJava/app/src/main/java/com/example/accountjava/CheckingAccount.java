package com.example.accountjava;

import Account;

public class CheckingAccount extends Account{

    public final double interest;

    public CheckingAccount(String accountNumber, int balance, double interest){
        super (accountNumber, balance);
        this.interest = interest;
    }

    void withdtaw(int amount){

    }

    void deposit(int amount){
        setBalance(getBalance() + amount);
    }

    void aMonthHasePassed(){
        setBalance((int)(getBalance() * (1+ interest)));
    }
}
