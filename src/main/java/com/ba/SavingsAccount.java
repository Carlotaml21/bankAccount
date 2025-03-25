package com.ba;

public class SavingsAccount extends BankAccount {

    private boolean active;

    public SavingsAccount(float initialBalance, float annualRate) {
        super(initialBalance, annualRate);
        this.active = initialBalance >= 10000;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public void deposit(float amount) {
        if (active) {
            super.deposit(amount);
        }
    }
}
