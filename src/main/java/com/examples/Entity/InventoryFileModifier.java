package com.examples.Entity;

import com.examples.Exception.InventoryFileWritingException;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;

public class InventoryFileModifier implements FileGenerator {
    public void modifyAccountsBalance(String account, BigDecimal amount) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Inventory.txt"));
        File tempFile = new File("myTempFile.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String lineToRemove = account;
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if (!trimmedLine.contains(lineToRemove)) continue;
            writer.write(account + "\t" + amount.toString() + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        Files.delete(FileGenerator.inventory);
        boolean successful = tempFile.renameTo(new File("Inventory.txt"));
    }
}
