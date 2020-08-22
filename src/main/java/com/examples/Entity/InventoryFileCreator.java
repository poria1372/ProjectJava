package com.examples.Entity;

import com.examples.Exception.InventoryFileCreationException;
import com.examples.Exception.InventoryFileWritingException;
import com.examples.Log.Log4j;
import com.examples.Utility.RandomGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class InventoryFileCreator implements FileGenerator {
    public void createInventoryFile() throws InventoryFileCreationException, InventoryFileWritingException {
        try {
            Files.createFile(inventory);
        } catch (IOException e) {
            throw new InventoryFileCreationException();
        }
        String defaultRecord = "1.10.100.1" + "\t";
        String finalRecordString = null;
        int inventoryRandom = RandomGenerator.getRandomNumber(1000000, 1000000);
        finalRecordString = defaultRecord.concat(String.valueOf(inventoryRandom).concat(""));
        try {
            Files.write(inventory, finalRecordString.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new InventoryFileWritingException();
        }
        Log4j.getLogger().info("Inventory file create Successfully!");
    }
}
