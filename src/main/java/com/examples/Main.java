package com.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Path path= Paths.get("c:/java/Payment.txt");
        if(Files.exists(path))
        {
            System.out.println("file Payment alerday exists");
        }
        else
        {
            Path done=Files.createFile(path);

        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        while(true) {

            System.out.println("pleae enter Record:");

            String record = bufferedReader.readLine();
            Files.write(done, record.getBytes(), StandardOpenOption.APPEND);

            }





        }
        Path path1=Paths.get("c:/java/Inventory.txt");
        if(Files.exists(path1))
        {
            System.out.println("file Invertory alerday exists");
        }
        else {
            Path done1 = Files.createFile(path1);

            String content2 = "1.10.100.1  1000000";
            Files.write(done1, content2.getBytes());
        }


    }
}
