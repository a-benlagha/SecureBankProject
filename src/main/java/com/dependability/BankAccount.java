package com.dependability;

public class BankAccount {

    // JML: Mark private field as public for specification purposes
    /*@ public spec_public @*/
    private double balance;
    
    // New field for the owner name
    private String owner;

    // JML: Invariant - Balance must never be negative
    /*@ public invariant balance >= 0.0; @*/

    /**
     * Creates a new bank account with an initial balance.
     */
    /*@ requires initialBalance >= 0.0;
      @ ensures this.balance == initialBalance;
      @*/
    public BankAccount(String owner, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.owner = owner;
        this.balance = initialBalance;
    }

    // Getter for owner (Required for tests)
    public String getOwner() {
        return owner;
    }

    /**
     * Deposits money into the account.
     */
    /*@ requires amount > 0.0;
      @ ensures balance == \old(balance) + amount;
      @*/
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
    }

    /**
     * Withdraws money from the account.
     */
    /*@ requires amount > 0.0;
      @ requires amount <= this.balance;
      @ ensures balance == \old(balance) - amount;
      @*/
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= amount;
    }

    /**
     * Returns the current balance.
     */
    /*@ ensures \result == balance; @*/
    public /*@ pure @*/ double getBalance() {
        return this.balance;
    }
}