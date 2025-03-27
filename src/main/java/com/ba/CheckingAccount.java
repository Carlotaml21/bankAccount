package com.ba;

public class CheckingAccount  extends BankAccount {
    private float overdraft = 0f;

    public CheckingAccount(float initialBalance, float annualRate) {
        super(initialBalance, annualRate);
    }

    public float getOverdraft() {
        return overdraft;
    }

    @Override
    public void withdraw(float amount) {
        float actualBalance = getBalance();

        if (amount <= actualBalance) {
            super.withdraw(amount);
        } else {
            float difference = amount - actualBalance;

            super.withdraw(actualBalance);
            overdraft += difference;
        }
    }

    @Override
        public void deposit(float amount) {
            if (overdraft > 0) {
                if (amount >= overdraft) {
                    float remainder = amount - overdraft;
                    overdraft = 0;
                    super.deposit(remainder); // lo que sobra va al saldo
                } else {
                    overdraft -= amount; // aún queda sobregiro
                }
            } else {
                super.deposit(amount);
            }
        }

    @Override
    public void monthlyStatement() {
        super.monthlyStatement();
    }

    public String printCheckAccountInfo() {
        int totalTtransanctions = getDepositCount() + getWithdrawCount();

        return "Saldo: " + getBalance() + "\n" +
            "Comisión mensual: " + getMonthlyFee() + "\n" +
            "Transacciones: " + totalTtransanctions + "\n" +
            "Sobregiro: " + overdraft;
    }


}


