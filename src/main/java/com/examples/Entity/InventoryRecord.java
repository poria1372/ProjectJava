package com.examples.Entity;

import java.math.BigDecimal;

public class InventoryRecord {
    String accountNumber;
    BigDecimal amount;

    public InventoryRecord() {
    }

    public InventoryRecord(String accountNumber, BigDecimal amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public InventoryRecord setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public InventoryRecord setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public String toString() {
        return "InventoryRecord{" +
                "accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
