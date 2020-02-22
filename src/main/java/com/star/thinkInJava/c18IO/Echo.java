package com.star.thinkInJava.c18IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {

    public static void main(String[] args) throws IOException {
        BufferedReader sdin = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = sdin.readLine()) != null && s.length() != 0 ) {
            System.out.println(s);
        }

    }
}
