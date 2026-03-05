package com.ontwikkelpad.week2.service;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.ontwikkelpad.week1.BankAccount;

public class TransferServiceTest {

    @Test
    void transfer_shouldMoveMoneyBetweenAccounts() {
        // Arrange
        BankAccount sourceAccount = new BankAccount("123", "Justin");
        BankAccount targetAccount = new BankAccount("456", "Albert");
        TransferService transfer = new TransferServiceImpl();

        sourceAccount.deposit(new BigDecimal("100"));
        targetAccount.deposit(new BigDecimal("50"));

        // Act
        transfer.transfer(sourceAccount, targetAccount, new BigDecimal("30"));

        // Assert
        assertEquals(new BigDecimal("70"), sourceAccount.getBalance());
        assertEquals(new BigDecimal("80"), targetAccount.getBalance());

    }

}
