package com.examples.Entity;

import com.examples.Exception.TransactionFileReadingException;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionFileReader implements FileGenerator {
    public List<TransactionRecord> readTransactionFile() throws TransactionFileReadingException {
        Stream<String> line = null;
        try {
            line = Files.lines(transactions);
        } catch (IOException e) {
            throw new TransactionFileReadingException();

        }
        List<TransactionRecord> transactionRecordList = line.map(s -> createTransactionsObject(s)).collect(Collectors.toList());
        return transactionRecordList;
    }

    private TransactionRecord createTransactionsObject(String s) {
        String[] columnDetail = s.split("\t", -1);
        TransactionRecord transactionRecord = new TransactionRecord();
        transactionRecord.setDebtorAccountNumber(columnDetail[0]);
        transactionRecord.setCreditorAccountNumber(columnDetail[1]);

        return transactionRecord;

    }
}
