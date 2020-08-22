package com.examples.Entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collector;

public class TransactionRecord {
    String debtorAccountNumber;
    String creditorAccountNumber;
    BigDecimal amount;

    public TransactionRecord(String debtorAccountNumber, String creditorAccountNumber, BigDecimal amount) {
        this.debtorAccountNumber = debtorAccountNumber;
        this.creditorAccountNumber = creditorAccountNumber;
        this.amount = amount;
    }

    public TransactionRecord() {

    }

    @Override
    public String toString() {
        return "TransactionRecord{" +
                "debtorAccountNumber='" + debtorAccountNumber + '\'' +
                ", creditorAccountNumber='" + creditorAccountNumber + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getDebtorAccountNumber() {
        return debtorAccountNumber;
    }

    public TransactionRecord setDebtorAccountNumber(String debtorAccountNumber) {
        this.debtorAccountNumber = debtorAccountNumber;
        return this;
    }

    public String getCreditorAccountNumber() {
        return creditorAccountNumber;
    }

    public TransactionRecord setCreditorAccountNumber(String creditorAccountNumber) {
        this.creditorAccountNumber = creditorAccountNumber;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionRecord setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

}
