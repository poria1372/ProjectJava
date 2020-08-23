package com.examples.Entity;

import java.math.BigDecimal;

public class PaymentRecord {
    String paymentType;
    String accountNumber;
    BigDecimal amount;


    public PaymentRecord() {
    }

    public PaymentRecord(String paymentType, BigDecimal amount, String accountNumber) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "PaymentRecord{" +
                "paymentType='" + paymentType + '\'' +
                ", amount=" + amount +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

    public String getPaymentType() {
        return paymentType;
    }

    public PaymentRecord setPaymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentRecord setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public PaymentRecord setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }
}
