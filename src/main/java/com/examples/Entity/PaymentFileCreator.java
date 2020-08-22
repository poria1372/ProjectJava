package com.examples.Entity;

import com.examples.Exception.PaymentFileCreationException;
import com.examples.Exception.PaymentFileWritingException;
import com.examples.Log.Log4j;
import com.examples.Utility.RandomGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class PaymentFileCreator implements FileGenerator {
    public void createPaymentFile() throws PaymentFileCreationException, PaymentFileWritingException {
        try {
            Files.createFile(payment);
        } catch (IOException e) {
            throw new PaymentFileCreationException();
        }
        String lastRecord = null;
        String content = "debtor" + "\t" + "1.10.100.1" + "\t" + "100000\n";
        try {
            Files.write(payment, content.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new PaymentFileWritingException();
        }
        String defaultRecord = "creditor" + "\t" + "1.20.100.";
        String finalRecordString = null;
        for (int i = 1; i < 100; i++) {
            int amountRandom = RandomGenerator.getRandomNumber(1000, 2000);
            int amount=Integer.parseInt(String.valueOf(amountRandom));
            String s2 = defaultRecord.concat(String.valueOf(i));
            String s3 = s2.concat("\t");
            finalRecordString = s3.concat(String.valueOf(amountRandom).concat("\n"));
            try {
                Files.write(payment, (finalRecordString).getBytes(), StandardOpenOption.APPEND);

            } catch (IOException e) {
                throw new PaymentFileWritingException();
            }
        }

        Log4j.getLogger().info("Payment file create successfully!");
    }
}
