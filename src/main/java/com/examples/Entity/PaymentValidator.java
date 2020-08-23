package com.examples.Entity;

import com.examples.Exception.DebtorAmountException;

import java.math.BigDecimal;
import java.util.List;

public class PaymentValidator {
    public boolean isValidPayment(List<PaymentRecord> paymentRecords, BigDecimal debtorAmount) throws DebtorAmountException {
        BigDecimal sumOfDebtors = BigDecimal.ZERO;


        for (PaymentRecord paymentRecord : paymentRecords) {
            if (paymentRecord.getPaymentType().equals(PaymentTypesStatic.creditPaymentType))
                sumOfDebtors = sumOfDebtors.add(paymentRecord.amount);
        }

        if (sumOfDebtors.compareTo(paymentRecords.get(0).getAmount()) == 1) {
            return false;
        }

        return true;
    }
}
