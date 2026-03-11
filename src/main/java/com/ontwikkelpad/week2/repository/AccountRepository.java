package com.ontwikkelpad.week2.repository;

import com.ontwikkelpad.week1.BankAccount;

public interface AccountRepository {

    BankAccount findByAccountNumber(String accountNumber);

    void save(BankAccount account);

}
