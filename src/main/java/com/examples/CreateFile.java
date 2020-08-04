package com.examples;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class CreateFile {
    public static void main(String[] args) throws Exception {
        Path path1 = Paths.get("c:/java/Payment.txt");
        if (Files.exists(path1)) {
            System.out.println("file Payment alerday exists");
        } else {
            Path done1 = Files.createFile(path1);

            for (int i = 1; i <= 10; i++) {
                String content1 = "Creditor 1.20.100.1 10000 \r";

                Files.write(done1, content1.getBytes(), StandardOpenOption.APPEND);


            }
        }

        Path path2 = Paths.get("c:/java/Inventory.txt");
        if (Files.exists(path2)) {
            System.out.println("file Invertory alerday exists");
        } else {
            Path done2 = Files.createFile(path2);

            String content2 = "1.20.100.1  10000";
            Files.write(done2, content2.getBytes(), StandardOpenOption.APPEND);


        }
        Path filePath = Paths.get("c:/java", "Payment.txt");
        Stream<String> lines1 = Files.lines(filePath);
        lines1.forEach(System.out::println);

        System.out.println("________________________________");

        Path filePath1 = Paths.get("c:/java", "Inventory.txt");
        Stream<String> lines2 = Files.lines(filePath1);
        lines2.forEach(System.out::println);
        System.out.println("Inventory balance is 10000 ");

    }


}




