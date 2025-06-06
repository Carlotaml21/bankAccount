package com.ba;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {

    @Test
    public void testSavingsAccountIsActive() {
        SavingsAccount account = new SavingsAccount(12000f, 0.05f);
        assertTrue(account.isActive());
    }

    @Test
    public void testSavingsAccountIsInactive() {
        SavingsAccount account = new SavingsAccount(5000f, 0.05f);
        assertFalse(account.isActive());
    }

    @Test
    public void testDepositInActiveAccountIncreases(){
        SavingsAccount account = new SavingsAccount(12000f, 0.05f);
        account.deposit(1000f);
        assertEquals(13000, account.getBalance(), 0.001f);
    }

    @Test
    public void testWithdrawInActiveAccountDecreases(){
        SavingsAccount account = new SavingsAccount(12000f, 0.05f);
        account.withdraw(1000f);
        assertEquals(11000, account.getBalance(), 0.001f);
    }

    @Test
    public void testWithdrawInInactiveAccountNotChange(){
        SavingsAccount account = new SavingsAccount(5000f, 0.05f);
        account.withdraw(1000f);
        assertEquals(5000f, account.getBalance(), 0.001f);

    }

    @Test
    public void testExtraFeesForWithdrawOver4(){
        SavingsAccount account = new SavingsAccount(12000f, 0.05f);

        account.withdraw(1000f);
        account.withdraw(1000f);
        account.withdraw(1000f);
        account.withdraw(1000f);
        account.withdraw(1000f);
        account.withdraw(1000f);

        account.monthlyStatement();

        float expectedBalanceBeforeInterest = 12000f - 6000f - (2*1000f);
        float expectedInterest = expectedBalanceBeforeInterest * (0.05f /12);
        float expectedBalanceAfterInterest = expectedBalanceBeforeInterest + expectedInterest;

        assertEquals(expectedBalanceAfterInterest, account.getBalance(), 0.001f);

        assertFalse(account.isActive());

    }

    @Test
    public void testPrintDetailsInfo(){
        SavingsAccount account = new SavingsAccount(12000f, 0.05f);

        account.setMonthlyFee(500f);
        account.deposit(1000f);
        account.withdraw(500f);

        String details = account.printDetailsInfo();
        assertTrue(details.contains("Saldo: 12500.0"));
        assertTrue(details.contains("Comisión mensual: 500.0"));
        assertTrue(details.contains("Transacciones: 2"));
    }


}
