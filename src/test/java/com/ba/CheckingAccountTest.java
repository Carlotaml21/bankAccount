package com.ba;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckingAccountTest{

    @Test
        public void testOverdraft(){
    CheckingAccount account = new CheckingAccount (1000f, 0.05f);
    account.withdraw(1500f);

    assertEquals(0f, account.getBalance(), 0.001f);
    assertEquals(500f, account.getOverdraft(), 0.001f);
    }

    @Test public void testDepositReducesOverdraft(){
        CheckingAccount account = new CheckingAccount (1000f, 0.05f);
        account.withdraw(1500f);
        account.deposit(300f);

        assertEquals(0f, account.getBalance(), 0.001f);
        assertEquals(200f, account.getOverdraft(), 0.001f);
    }

    @Test public void testMonthlyStatementCheckingAccount(){
        CheckingAccount account = new CheckingAccount (1000f, 0.05f);
        account.setMonthlyFee(500f);

        account.monthlyStatement();

        float expected = (10000f - 500f) + ((10000f - 500f) * (0.12f/ 12));

        assertEquals(expected, account.getBalance(), 0.001f);
    }
}
