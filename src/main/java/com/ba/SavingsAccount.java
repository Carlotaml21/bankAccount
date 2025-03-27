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

    @Override
    public void withdraw(float amount) {
        if (active) {
            super.withdraw(amount);
        }
    }

    @Override
    public void monthlyStatement() {
        int extraWithdrawals = Math.max(0, getWithdrawCount() - 4);
        float extraFees = extraWithdrawals * 1000f;

        setMonthlyFee(getMonthlyFee() + extraFees);

        super.monthlyStatement();

        this.active = getBalance() >= 10000;
    }

    public String printDetailsInfo() {
        int transacciones = getDepositCount() + getWithdrawCount();

        return "Saldo: " + getBalance() + "\n" +
            "Comisión mensual: " + getMonthlyFee() + "\n" +
            "Transacciones: " + transacciones;
    }

}
