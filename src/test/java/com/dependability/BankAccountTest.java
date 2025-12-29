package com.dependability;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be 150 after depositing 50");
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), "Balance should be 60 after withdrawing 40");
    }

    @Test
    public void testInsufficientFunds() {
        BankAccount account = new BankAccount(50.0);
        // Expect an exception when withdrawing more than the balance
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100.0);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    public void testNegativeInitialBalance() {
        // Expect an exception when creating an account with negative balance
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-100.0);
        });
        assertEquals("Balance cannot be negative", exception.getMessage());
    }
}