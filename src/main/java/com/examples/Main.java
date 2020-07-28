package com.examples;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        writeFileChannel(ByteBuffer.wrap(" PouriaKarimi 639882688 1000000 \n MeysamKarimi 584712698 300000 \n  AmirHatami 6398258441 500000 ".getBytes()));


    }
    public static void writeFileChannel(ByteBuffer byteBuffer)throws Exception {
        Set<StandardOpenOption> options = new HashSet<>();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.APPEND);
        Path path = Paths.get("c:/java/person.txt");
        FileChannel fileChannel = FileChannel.open(path, options);
        fileChannel.write(byteBuffer);
        fileChannel.close();
    }
}


