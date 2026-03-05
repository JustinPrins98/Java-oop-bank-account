package com.ontwikkelpad.week2.service;

import com.ontwikkelpad.week1.BankAccount;
import java.math.BigDecimal;

public class TransferServiceImpl implements TransferService {

    @Override
    public void transfer(BankAccount source, BankAccount target, BigDecimal amount) {
        source.transferTo(target, amount);
    }

}
