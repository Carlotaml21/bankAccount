package com.ba;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckingAccountTest{
    CheckingAccount account = new CheckingAccount (1000f, 005f);
    account.withdraw(1500f);

    assertEquals(0f, account.getBalance(), 0,001f);
    assertEquals(500f, account.getOverdraft(), 0.001f);

}
