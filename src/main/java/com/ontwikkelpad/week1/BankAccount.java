package com.ontwikkelpad.week1;

import java.math.BigDecimal;

public class BankAccount {

    private final String accountNumber;
    private final String ownerName;
    private BigDecimal balance;

    public BankAccount(String accountNumber, String ownerName) {

        // Validation
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number must not be blank");
        }

        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name must not be blank");
        }

        // Assign
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = BigDecimal.ZERO;
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount must not be null");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

    public void deposit(BigDecimal amount) {

        validateAmount(amount);

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {

        validateAmount(amount);

        if (amount.compareTo(balance) > 0) {
            throw new IllegalStateException("Insufficient balance");
        }

        balance = balance.subtract(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void transferTo(BankAccount target, BigDecimal amount) {

        if (target == null) {
            throw new IllegalArgumentException("Target must not be blank");
        }

        if (target == this) {
            throw new IllegalArgumentException("Target can not be itself");
        }

        this.withdraw(amount);
        target.deposit(amount);
    }
}
