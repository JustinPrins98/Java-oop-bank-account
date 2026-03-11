package com.ontwikkelpad.week2.repository;

import java.util.HashMap;
import java.util.Map;

import com.ontwikkelpad.week2.exceptions.AccountNotFoundException;

import com.ontwikkelpad.week1.BankAccount;

public class InMemoryAccountRepository implements AccountRepository {

    private Map<String, BankAccount> accounts = new HashMap<>();

    public BankAccount findByAccountNumber(String accountNumber) {

        if (!accounts.containsKey(accountNumber)) {
            throw new AccountNotFoundException("Account not found" + accountNumber);
        }

        return accounts.get(accountNumber);
    }

    public void save(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }
}