package com.ontwikkelpad.week1;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void deposit_increases_balance() {
        // Arrange
        BankAccount bankAccount = new BankAccount("123", "Justin");
        // Act
        bankAccount.deposit(BigDecimal.valueOf(100));

        // Assert
        assertEquals(BigDecimal.valueOf(100), bankAccount.getBalance());
    }

    @Test
    void deposit_with_null_amount_throws_exception() {
        // Arrange
        BankAccount bankAccount = new BankAccount("123", "Justin");

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(null);
        });
    }

    @Test
    void deposit_with_zero_amount_throws_exception() {
        // Arrange
        BankAccount bankAccount = new BankAccount("123", "Justin");

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(BigDecimal.ZERO);
        });
    }

    // Withdraw test
    @Test
    void withdraw_decreases_balance() {
        // Arrange
        BankAccount bankAccount = new BankAccount("123", "Justin");
        bankAccount.deposit(BigDecimal.valueOf(100));
        // Act
        bankAccount.withdraw(BigDecimal.valueOf(40));
        // Assert
        assertEquals(BigDecimal.valueOf(60), bankAccount.getBalance());
    }

    @Test
    void withdraw_with_insufficient_balance_throws_exception() {
        // Arrange
        BankAccount bankAccount = new BankAccount("123", "Justin");
        bankAccount.deposit(BigDecimal.valueOf(50));

        // Assert
        assertThrows(IllegalStateException.class, () -> {
            bankAccount.withdraw(BigDecimal.valueOf(60));
        });
    }

    @Test
    void withdraw_with_null_amount_throws_exception() {
        // Arrange
        BankAccount bankAccount = new BankAccount("123", "Justin");

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(null);
        });
    }

    @Test
    void withdraw_with_zero_amount_throws_exception() {
        // Arrange
        BankAccount bankAccount = new BankAccount("123", "Justin");

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(BigDecimal.ZERO);
        });
    }

    @Test
    void transfer_decreases_source_and_increases_target() {
        // Arrange
        BankAccount bankAccountSource = new BankAccount("123", "Justin");
        bankAccountSource.deposit(BigDecimal.valueOf(100));

        BankAccount bankAccountTarget = new BankAccount("345", "Klaas");
        // Act
        bankAccountSource.transferTo(bankAccountTarget, BigDecimal.valueOf(40));

        // Assert
        assertEquals(BigDecimal.valueOf(60), bankAccountSource.getBalance());
        assertEquals(BigDecimal.valueOf(40), bankAccountTarget.getBalance());
    }

    @Test
    void transfer_to_null_target_throws_exception() {
        // Arrange
        BankAccount bankAccountSource = new BankAccount("123", "Justin");
        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccountSource.transferTo(null, BigDecimal.valueOf(10));
        });
    }

    @Test
    void transfer_to_same_account_throws_exception() {
        // Arrange
        BankAccount bankAccountSource = new BankAccount("123", "Justin");
        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccountSource.transferTo(bankAccountSource, BigDecimal.valueOf(10));
        });
    }
}
