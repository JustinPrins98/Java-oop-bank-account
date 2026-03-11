package com.ontwikkelpad.week2.service;

import java.math.BigDecimal;

public interface TransferService {

    void transfer(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount);

}
