package com.examples;


import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {


        Path path= Paths.get("c:\\java\\Debtor.txt");
       Path done= Files.createFile(path);

            String content="pouriaKArimi 639852147 500000 \n MeysamKarimi 369852147 3000000";

            Files.write(path,content.getBytes(), StandardOpenOption.APPEND);


        System.out.println("file created ");

    }
}