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

    public void setMonthlyFee(float fee) {
        this.monthlyFee = fee;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
            depositCount++;
        }
    }
    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            withdrawCount++;
        }
    }

    public void calculateMonthlyInterest() {
        float monthlyRate = annualRate / 12;
        float interest = balance * monthlyRate;
        balance += interest;
    }
}




