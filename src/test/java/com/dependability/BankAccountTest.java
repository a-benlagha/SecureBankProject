package com.dependability;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    // 1. Test successful account initialization
    @Test
    void testAccountInitialization() {
        BankAccount account = new BankAccount("John Doe", 100.0);
        assertEquals(100.0, account.getBalance(), "Initial balance should be 100.0");
        assertEquals("John Doe", account.getOwner(), "Owner name should be John Doe");
    }

    // 2. Test valid deposit
    @Test
    void testValidDeposit() {
        BankAccount account = new BankAccount("John Doe", 50.0);
        account.deposit(20.0);
        assertEquals(70.0, account.getBalance(), "Balance should be 70.0 after depositing 20.0");
    }

    // 3. Test valid withdrawal
    @Test
    void testValidWithdraw() {
        BankAccount account = new BankAccount("John Doe", 100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), "Balance should be 60.0 after withdrawing 40.0");
    }

    // 4. Test exception for negative deposit
    @Test
    void testNegativeDeposit() {
        BankAccount account = new BankAccount("John Doe", 50.0);
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10.0);
        }, "Should throw exception for negative deposit");
    }

    // 5. Test exception for negative withdrawal
    @Test
    void testNegativeWithdraw() {
        BankAccount account = new BankAccount("John Doe", 50.0);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-5.0);
        }, "Should throw exception for negative withdrawal");
    }

    // 6. Test exception for insufficient funds (Overdraft)
    @Test
    void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount("John Doe", 50.0);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100.0);
        }, "Should throw exception for insufficient funds");
    }
}