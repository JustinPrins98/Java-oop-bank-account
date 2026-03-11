package com.ontwikkelpad.week2.service;

import com.ontwikkelpad.week1.BankAccount;
import com.ontwikkelpad.week2.repository.AccountRepository;

import java.math.BigDecimal;

public class TransferServiceImpl implements TransferService {

    private AccountRepository repository;

    public TransferServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void transfer(String sourceAccountNumber,
            String targetAccountNumber,
            BigDecimal amount) {

        BankAccount source = repository.findByAccountNumber(sourceAccountNumber);
        BankAccount target = repository.findByAccountNumber(targetAccountNumber);

        source.transferTo(target, amount);

        repository.save(source);
        repository.save(target);
    }
}