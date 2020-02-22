package com.star.thinkInJava.c18IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if (fl != null) {
            System.out.println("Lock File");
            System.out.println(fl.isShared());
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("Release Lock");
        }
        fos.close();

    }
}
