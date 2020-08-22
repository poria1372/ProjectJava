package com.examples.Entity;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileGenerator {
    Path payment = Paths.get("Payment.txt");
    Path inventory = Paths.get("Inventory.txt");
    Path transactions = Paths.get("Transactions.txt");

}
