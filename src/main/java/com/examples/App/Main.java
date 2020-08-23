package com.examples.App;

import com.examples.Entity.*;
import com.examples.Exception.*;
import com.examples.Log.Log4j;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public static void main(String[] args) throws PaymentFileWritingException, PaymentFileCreationException, PaymentFileReadingException, InventoryFileCreationException, InventoryFileWritingException, InventoryFileReadingException, TransactionFileCreationException, TransactionFileWritingException, TransactionFileReadingException, DebtorAmountException, IOException {
        try {
            System.out.println("! Deleting File From The Configured Path !");
            Files.delete(FileGenerator.transactions);
            Files.delete(FileGenerator.payment);
            Files.delete(FileGenerator.inventory);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
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

        PaymentValidator paymentValidator = new PaymentValidator();
        if (!paymentValidator.isValidPayment(paymentRecordList, inventoryRecordList.get(0).getAmount()))
            throw new DebtorAmountException("some of payment amounts is more than inventory amount");
        BigDecimal someOfCreditorAmount = calculateSomeOfCreditorAmount(paymentRecordList);

        TransactionFileCreator transactionFileCreator = new TransactionFileCreator();
        transactionFileCreator.createTransactionFile(paymentRecordList);

        InventoryFileModifier inventoryFileModifier = new InventoryFileModifier();
        inventoryFileModifier.modifyAccountsBalance(paymentRecordList.get(0).getAccountNumber(), inventoryRecordList.get(0).getAmount().subtract(someOfCreditorAmount));

        TransactionFileReader transactionFileReader = new TransactionFileReader();
        List<TransactionRecord> transactionRecordList = transactionFileReader.readTransactionFile();
        for (TransactionRecord transactionRecord : transactionRecordList) {
            Log4j.getLogger().info(transactionRecord.toString());
        }
    }

    private static BigDecimal calculateSomeOfCreditorAmount(List<PaymentRecord> paymentRecordList) {
        BigDecimal sumOfDebtors = BigDecimal.ZERO;
        for (PaymentRecord paymentRecord : paymentRecordList) {
            if (paymentRecord.getPaymentType().equals(PaymentTypesStatic.creditPaymentType))
                sumOfDebtors = sumOfDebtors.add(paymentRecord.getAmount());
        }
        return sumOfDebtors;
    }
}

