package com.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path= Paths.get("c:\\java\\Debtor.txt");
        Path done= Files.createFile(path);

        String content="pouriaKArimi 639852147 500000 \n MeysamKarimi 369852147 3000000";

        Files.write(path,content.getBytes(), StandardOpenOption.APPEND);


        System.out.println("file created ");

    }
}

