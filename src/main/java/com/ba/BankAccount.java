package com.ba;

public class BankAccount {

    private float balance;
    private int depositCount = 0;
    private int withdrawCount = 0;
    private float annualRate;
    private float monthlyFee = 0;


    public BankAccount(float initialBalance, float annualRate) {
        this.balance = initialBalance;
        this.annualRate = annualRate;
    }

    public float getBalance() {
        return balance;
    }

    public float getAnnualRate() {
        return annualRate;
    }
}



