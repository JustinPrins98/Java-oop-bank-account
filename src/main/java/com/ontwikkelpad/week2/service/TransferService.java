package com.ontwikkelpad.week2.service;

import com.ontwikkelpad.week1.BankAccount;
import java.math.BigDecimal;

public interface TransferService {

    void transfer(BankAccount source, BankAccount target, BigDecimal amount);

}
