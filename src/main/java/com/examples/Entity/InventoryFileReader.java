package com.examples.Entity;

import com.examples.Exception.InventoryFileReadingException;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InventoryFileReader implements FileGenerator {
    public List<InventoryRecord> readFile() throws InventoryFileReadingException {
        Stream<String> lines = null;
        try {
            lines = Files.lines(inventory);
        } catch (IOException e) {
            throw new InventoryFileReadingException();
        }
        List<InventoryRecord> inventoryRecordList = lines.map(s -> createInventoryRecordObject(s)).collect(Collectors.toList());
        return inventoryRecordList;
    }

    private InventoryRecord createInventoryRecordObject(String s) {
        String[] coulumnDetail = s.split("\t", -1);
        InventoryRecord inventoryRecord = new InventoryRecord();
        inventoryRecord.setAccountNumber(coulumnDetail[0]);
        inventoryRecord.setAmount(new BigDecimal(coulumnDetail[1]));
        return inventoryRecord;
    }

}
