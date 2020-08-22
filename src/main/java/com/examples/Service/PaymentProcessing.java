package com.examples.Service;

import com.examples.Entity.FileGenerator;
import com.examples.Entity.PaymentFileCreator;
import com.examples.Entity.PaymentRecord;
import com.examples.Log.Log4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class PaymentProcessing{
     boolean debtorsInventoryIsEnough = false;
     int remainOfCredit = 0;
     String lastDebtor = "";

       /* public void Handler(String PaymentRecord) {
        String[] paymentRecord = PaymentRecord.split("\t");
        if (paymentRecord.length == 3) {
            if (paymentRecord[0].equals("debtor") || paymentRecord[0].equals("creditor")) {
                if (paymentRecord[0].equals("debtor")) {
                    writer(transactions, PaymentRecord);
                    debtorsInventoryIsEnough = false;
                    int amount = Integer.parseInt(paymentRecord[2]);
                    remainOfCredit = amount;
                    String accountNumber = paymentRecord[1];
                    lastDebtor = accountNumber;
                    if (debtorsInventoryIsEnough(accountNumber, amount)) {
                        debtorsInventoryIsEnough = true;
                    } else {
                        Log4j.getLogger().info("debtors inventory is less than debt");
                        return;
                    }
                } else if (paymentRecord[0].equals("creditor")) {
                    if (debtorsInventoryIsEnough) {
                        writer(transactions, PaymentRecord);
                        String accountNumber = paymentRecord[1];
                        String amount = paymentRecord[2];
                        if (remainOfCreditIsEnough(Integer.parseInt(amount))) {
                            remainOfCredit -= Integer.parseInt(amount);
                            writeTransaction(lastDebtor, accountNumber, amount);
                            int creditorLastInventory = creditorLastInventoryFinder(accountNumber);
                            updateInventoryFile(accountNumber, (creditorLastInventory + Integer.parseInt(amount)));
                        } else {
                            Log4j.getLogger().info("Amount of remained credit(debt from debtor) is less than credit amount for creditor!");
                        }
                    } else {
                        Log4j.getLogger().info("debtors inventory is less than debt");
                        return;
                    }
                }
            }
        }
    }*/


}
