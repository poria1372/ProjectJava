package com.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) throws Exception {

        try {
            Path file1= Paths.get("c:/java/Payment.txt");
            Path done1=Files.createFile(file1);
            for(int i=1; i<21; i++) {
                String contetnt1= "Creditor  1.20.100.1  1000000\n";
                Files.write(done1, contetnt1.getBytes(),StandardOpenOption.APPEND);
            }

            Path file2=Paths.get("c:/java/Inventoy.txt");
            Path done2=Files.createFile(file2);
            String content2="1.10.100.1  1000000";
            Files.write(done2,content2.getBytes());
            System.out.println("create file");



        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
