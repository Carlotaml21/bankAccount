package com.ba;

public class CheckingAccount  extends BankAccount{
    private float overdraft = 0f;

    public CheckingAccount(float initialBalance, float annualRate){
        super(initialBalance, annualRate);
    }

    public float getOverdraft(){
        return overdraft;
    }

    @Override
    public void withdraw(float amount){
        float actualBalance = getBalance();

        if(amount<= actualBalance) {
            super.withdraw(amount);
        }else {
            float difference = amount - actualBalance;

            super.withdraw(actualBalance);
            overdraft += difference;
        }

    }
}

