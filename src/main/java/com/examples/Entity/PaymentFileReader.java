package com.examples.Entity;

import com.examples.Exception.PaymentFileReadingException;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PaymentFileReader implements FileGenerator {
    public List<PaymentRecord> readFile() throws PaymentFileReadingException {
        Stream<String> lines = null;
        try {
            lines = Files.lines(payment);
        } catch (IOException e) {
            throw new PaymentFileReadingException();

        }
        List<PaymentRecord> paymentRecordList = lines.map(s -> createPaymentRecordObject(s)).collect(Collectors.toList());
        return paymentRecordList;

    }

    private PaymentRecord createPaymentRecordObject(String s) {
        String[] columnDetail = s.split("\t", -1);
        PaymentRecord paymentRecord = new PaymentRecord();
        paymentRecord.setPaymentType(columnDetail[0]);
        paymentRecord.setAccountNumber(columnDetail[1]);
        paymentRecord.setAmount(new BigDecimal(columnDetail[2]));
        return paymentRecord;
    }
}
