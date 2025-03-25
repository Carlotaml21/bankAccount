package com.ba;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {

    @Test
    public void testSavingsAccountIsActive() {
        SavingsAccount account = new SavingsAccount(12000f, 0.05f);
        assertTrue(account.isActive());
    }
}
