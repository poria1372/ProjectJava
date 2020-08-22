package com.examples.Entity;

import com.examples.Exception.TransactionFileCreationException;
import com.examples.Exception.TransactionFileWritingException;
import com.examples.Log.Log4j;
import com.examples.Utility.RandomGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TransactionFileCreator implements FileGenerator  {
    public void createTransactionFile() throws TransactionFileCreationException, TransactionFileWritingException {
        try {
            Files.createFile(transactions);
        } catch (IOException e) {
            throw new TransactionFileCreationException();
        }
        String defaultRecordTransaction="1.10.100.1"+"\t"+"1.20.100.";
        String finalRecord=null;
        for (int j=1; j<100; j++){
            String t1=defaultRecordTransaction.concat(String.valueOf(j));
            String t2=t1.concat("\t");
            finalRecord=t2.concat("\n");
            try {
                Files.write(transactions,finalRecord.getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e){
                throw new TransactionFileWritingException();
            }
        }
        Log4j.getLogger().info("Transaction file create successfully!");
    }

}

