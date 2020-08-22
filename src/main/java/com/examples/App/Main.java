package com.examples.App;

import com.examples.Entity.*;
import com.examples.Exception.*;
import com.examples.Log.Log4j;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    static {
        boolean debtorsInventoryIsEnough = false;
        int remainOfCredit = 0;
        String lastDebtor = "";
    }

    public static void main(String[] args) throws PaymentFileWritingException, PaymentFileCreationException, PaymentFileReadingException, InventoryFileCreationException, InventoryFileWritingException, InventoryFileReadingException, TransactionFileCreationException, TransactionFileWritingException, TransactionFileReadingException {

        InventoryFileCreator inventoryFileCreator = new InventoryFileCreator();
        inventoryFileCreator.createInventoryFile();


        InventoryFileReader inventoryFileReader = new InventoryFileReader();
        List<InventoryRecord> inventoryRecordList = inventoryFileReader.readFile();
        for (InventoryRecord inventoryRecord : inventoryRecordList) {
            Log4j.getLogger().info(inventoryRecord.toString());

        }

        PaymentFileCreator paymentFileCreator = new PaymentFileCreator();
        paymentFileCreator.createPaymentFile();

        PaymentFileReader paymentFileReader = new PaymentFileReader();
        List<PaymentRecord> paymentRecordList = paymentFileReader.readFile();
        for (PaymentRecord paymentRecord : paymentRecordList) {
            Log4j.getLogger().info(paymentRecord.toString());

        }
        TransactionFileCreator transactionFileCreator = new TransactionFileCreator();
        transactionFileCreator.createTransactionFile();

        TransactionFileReader transactionFileReader= new TransactionFileReader();
        List<TransactionRecord> transactionRecordList=transactionFileReader.readTransactionFile();
        for (TransactionRecord transactionRecord : transactionRecordList) {
            Log4j.getLogger().info(transactionRecord.toString());

        }

    }

}

