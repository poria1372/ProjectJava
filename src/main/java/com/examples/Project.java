package com.examples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Project {
    static Path paymentPath = Paths.get("c:/java/Payment.txt");
    static Path inventoryPath = Paths.get("c:/java/Inventory.txt");
    static Path transactionsPath = Paths.get("c:/java/Transactions.txt");

    static boolean debtorsInventoryIsEnough = false;
    static int remainOfCredit = 0;

    static String lastDebtor = "";

    public static void main(String[] args) {


        try {
            Files.createFile(paymentPath);
            System.out.println("Payment file create successfully!");
        } catch (IOException e) {
            System.out.println("Couldn't create a payment file; error : " + e.getMessage());
        }

        try {
            Files.createFile(inventoryPath);
            System.out.println("Inventory file create successfully!");
        } catch (IOException e) {
            System.out.println("Couldn't create a inventory file; error : " + e.getMessage());
        }

        try {
            Files.createFile(transactionsPath);
            System.out.println("Transactions file create successfully!");
        } catch (IOException e) {
            System.out.println("Couldn't create a transactions file; error : " + e.getMessage());
        }

        String command = "";
        Scanner commandScanner = new Scanner(System.in);
        while (!(command = commandScanner.nextLine()).equals("exit")) {
            commandHandler(command);
        }

    }


    private static void commandHandler(String command)  {
        String[] splittedCommand = command.split("  ");

        if (splittedCommand.length == 3) {

            if (splittedCommand[0].equals("debtor") || splittedCommand[0].equals("creditor")) {
                if (splittedCommand[0].equals("debtor")) {
                    writer(paymentPath, command);
                    System.out.println("write to paymentFile");
                    debtorsInventoryIsEnough = false;
                    int amount = Integer.parseInt(splittedCommand[2]);
                    remainOfCredit = amount;
                    String debtorID = splittedCommand[1];
                    lastDebtor = debtorID;
                    if (debtorsInventoryIsEnough(debtorID, amount)) {
                        debtorsInventoryIsEnough = true;
                    } else {
                        System.out.println("Debtors inventory is less than debt!");
                        return;
                    }
                } else if (splittedCommand[0].equals("creditor")) {
                    if (debtorsInventoryIsEnough) {
                        writer(paymentPath, command);
                        System.out.println("write to paymentFile");
                        String creditorID = splittedCommand[1];
                        String amount = splittedCommand[2];
                        if (remainedCreditIsEnough(parseInt(amount))) {
                            remainOfCredit -= parseInt(amount);
                            writeTransaction(lastDebtor, creditorID, amount);

                            int creditorLastInventory = creditorLastInventoryFinder(creditorID);
                            updateInventoryFile(creditorID, (creditorLastInventory + parseInt(amount)));
                        } else {
                            System.out.println("Amount of remained credit(debt from debtor) is less than credit amount for creditor!");
                        }
                    } else {
                        System.out.println("Debtors inventory is less than debt!");
                        return;
                    }
                }
            }

        } else if (splittedCommand.length == 2) {
            writer(inventoryPath, command);
            System.out.println("write to inventory file");
        } else {
            System.out.println("the command format is incorrect!");
        }


    }


    private static void writer(Path path, String command) {
        try {
            String editedCommand = command.concat("\n");
            Files.write(path, editedCommand.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("Couldn't write in file successfully!, error : " + ex.getMessage());
        }
    }


    private static ArrayList<String> reader(Path path) {
        ArrayList<String> records = new ArrayList<>();
        try {

            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                records.add(line);
            }
            return records;
        } catch (IOException ex) {
            System.out.println("Couldn't read file successfully!, error : " + ex.getMessage());
        }
        return null;
    }


    private static boolean debtorsInventoryIsEnough(String debtorID, int amount) {

        ArrayList<String> records = reader(inventoryPath);
        if (records != null) {
            boolean debtorIsExist = false;

            for (int counter = 0; counter < records.size(); counter++) {
                String[] splittedRecord = records.get(counter).split("   ");
                if (splittedRecord[0].equals(debtorID)) {
                    debtorIsExist = true;

                    int inventoryAmount = parseInt(splittedRecord[1]);
                    if (inventoryAmount >= amount) {
                        updateInventoryFile(debtorID, inventoryAmount - amount);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            if (!debtorIsExist) {
                System.out.println("debtor is not exist in inventory file!");
            }
        }
        return false;
    }


    private static void writeTransaction(String lastDebtor, String creditorID, String amount) {
        String transactionCommand = lastDebtor + "   " + creditorID + "   " + amount;
        writer(transactionsPath, transactionCommand);
    }


    private static void updateInventoryFile(String ID, int amount) {
        ArrayList<String> records = reader(inventoryPath);
        try {
            new FileOutputStream("InventoryFile");
        } catch (IOException ex) {
            System.out.println("Couldn't write in file successfully!, error : " + ex.getMessage());
        }
        boolean newInventoryRecord = true;
        for (String record : records) {
            String[] splittedRecords = record.split("  ");
            if (splittedRecords[0].equals(ID)) {
                newInventoryRecord = false;
                writer(inventoryPath, splittedRecords[0] + "   " + amount);
            } else {
                writer(inventoryPath, record);
            }
        }
        if (newInventoryRecord) {
            writer(inventoryPath, ID + "   " + amount);
        }
    }


    private static int creditorLastInventoryFinder(String creditorID) {
        ArrayList<String> records = reader(inventoryPath);
        for (String record : records) {
            String[] splittedRecord = record.split("   ");
            if (splittedRecord[0].equals(creditorID)) {
                return parseInt(splittedRecord[1]);
            }
        }
        return 0;
    }

    public static boolean remainedCreditIsEnough(int amount) {
        if (remainOfCredit - amount >= 0) {
            return true;
        }
        return false;
    }
}
