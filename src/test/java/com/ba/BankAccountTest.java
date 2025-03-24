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

}
