package com.ontwikkelpad.week2.service;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.ontwikkelpad.week1.BankAccount;
import com.ontwikkelpad.week2.exceptions.AccountNotFoundException;
import com.ontwikkelpad.week2.repository.AccountRepository;
import com.ontwikkelpad.week2.repository.InMemoryAccountRepository;

public class TransferServiceTest {

    @Test
    void transfer_shouldMoveMoneyBetweenAccounts() {
        // Arrange
        BankAccount sourceAccount = new BankAccount("123", "Justin");
        BankAccount targetAccount = new BankAccount("456", "Albert");

        AccountRepository repo = new InMemoryAccountRepository();
        repo.save(sourceAccount);
        repo.save(targetAccount);

        TransferService transfer = new TransferServiceImpl(repo);

        sourceAccount.deposit(new BigDecimal("100"));
        targetAccount.deposit(new BigDecimal("50"));

        // Act
        transfer.transfer("123", "456", new BigDecimal("30"));

        // Assert
        assertEquals(new BigDecimal("70"), repo.findByAccountNumber("123").getBalance());
        assertEquals(new BigDecimal("80"), repo.findByAccountNumber("456").getBalance());
    }

    @Test
    void transfer_fromNonExistingAccountShouldThrowException() {
        // Arrange
        BankAccount targetAccount = new BankAccount("456", "John");

        AccountRepository repo = new InMemoryAccountRepository();
        repo.save(targetAccount);

        TransferService transfer = new TransferServiceImpl(repo);

        // Assert
        assertThrows(AccountNotFoundException.class,
                () -> transfer.transfer("111", "456", new BigDecimal(10)));
    }

    @Test
    void transfer_ToNonExistingAccountShouldThrowException() {
        // Arrange
        BankAccount sourceAccount = new BankAccount("456", "John");

        AccountRepository repo = new InMemoryAccountRepository();
        repo.save(sourceAccount);

        TransferService transfer = new TransferServiceImpl(repo);

        // Assert
        assertThrows(AccountNotFoundException.class,
                () -> transfer.transfer("456", "111", new BigDecimal(10)));
    }
}