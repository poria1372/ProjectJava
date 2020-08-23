package com.examples.Entity;

import com.examples.Exception.TransactionFileCreationException;
import com.examples.Exception.TransactionFileWritingException;
import com.examples.Log.Log4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TransactionFileCreator implements FileGenerator {
    public void createTransactionFile(List<PaymentRecord> paymentRecords) throws TransactionFileCreationException, TransactionFileWritingException {
        try {
            Files.createFile(transactions);
        } catch (IOException e) {
            throw new TransactionFileCreationException();
        }
        String debtorAccountNumber = paymentRecords.get(0).getAccountNumber();
        for (PaymentRecord paymentRecord : paymentRecords) {
            if (!paymentRecord.getPaymentType().equals(PaymentTypesStatic.debitPaymentType)) {
                String result = debtorAccountNumber.concat("\t")
                        .concat(paymentRecord.getAccountNumber())
                        .concat("\t")
                        .concat(paymentRecord.getAmount().toString()).concat("\n");
                try {
                    Files.write(transactions, result.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    throw new TransactionFileWritingException();
                }
            }
        }
        Log4j.getLogger().info("Transaction file create successfully!");
    }

}

