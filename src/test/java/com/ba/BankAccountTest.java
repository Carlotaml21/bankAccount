package com.ba;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    @Test
    public void testDepositIncreasesBalance(){
        BankAccount account = new BankAccount(1000f, 0.05f);
        account.deposit(500f);

        assertEquals(1500f, account.getBalance());
    }
    @Test
    public void testWithdrawDecreasesBalance(){
        BankAccount account = new BankAccount(1000f, 0.05f);
        account.withdraw(300f);

        assertEquals(700f , account.getBalance(),0.001f);
    }

    @Test
    public void testCalculateMonthlyInterest(){
        BankAccount account = new BankAccount(1200f, 0.12f);
        account.calculateMonthlyInterest();

        assertEquals(1212f, account.getBalance(),0.001f);
    }

    @Test
    public void testMonthlyStatementUpdates(){
        BankAccount account = new BankAccount(1000f, 0.12f);
        account.setMonthlyFee(10f);

        account.monthlyStatement();

        assertEquals(999.9f, account.getBalance(), 0.001f);
    }

    @Test
    public void testPrintAccountInfo(){
        BankAccount account = new BankAccount(1000f, 0.05f);
        account.setMonthlyFee(10f);

        String info = account.printAccountInfo();

        assertTrue(info.contains("Saldo: 1000"));
        assertTrue(info.contains("Tasa anual: 0.05"));
        assertTrue(info.contains("Depósitos: 0"));
        assertTrue(info.contains("Retiros: 0"));
        assertTrue(info.contains("Comisión mensual: 10"));

}
}
