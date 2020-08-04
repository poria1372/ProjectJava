package com.examples;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Pay {
    public static void main(String[] args) throws Exception {
        Path path1 = Paths.get("c:/java/Transaction.txt");
        if (Files.exists(path1)) {
            System.out.println("file transaction alerday exist");
        } else {
            Path done1 = Files.createFile(path1);
            String content3 = "1.10.100.1  1.20.100.1 100\n" +
                    "1.10.100.1  1.20.100.2 200\n" +
                    "1.10.100.1  1.20.100.3 300\n" +
                    "1.10.100.1  1.20.100.4 400\n" +
                    "1.10.100.1  1.20.100.5 500\n" +
                    "1.10.100.1  1.20.100.6 600\n" +
                    "1.10.100.1  1.20.100.7 700\n" +
                    "1.10.100.1  1.20.100.8 800\n" +
                    "1.10.100.1  1.20.100.9 900";
            Files.write(done1, content3.getBytes());

        }

        Path path2 = Paths.get("c:/java/NewInventory.txt");
        if (Files.exists(path2)) {
            System.out.println("NewInventory Alerday Exist");
        } else {
            Path done2 = Files.createFile(path2);
            String content2 = "1.10.100.1  9.900\n" +
                    "1.10.100.1  9.700\n" +
                    "1.10.100.1  9.400\n" +
                    "1.10.100.1  9.000\n" +
                    "1.10.100.1  8.500\n" +
                    "1.10.100.1  7.900\n" +
                    "1.10.100.1  7.200\n" +
                    "1.10.100.1  6.400" +
                    "1.10.100.1  5.500";
            Files.write(done2, content2.getBytes());
        }


        Path filePath1 = Paths.get("c:/java", "Transaction.txt");
        Stream<String> lines1 = Files.lines(filePath1);
        lines1.forEach(System.out::println);
        System.out.println("____________________________");

        Path filePath2 = Paths.get("c:/java", "NewInventory.txt");
        Stream<String> lines2 = Files.lines(filePath2);
        lines2.forEach(System.out::println);
        System.out.println("___________________________");

        System.out.println("Inventory Balance is 5.500");
    }
}





