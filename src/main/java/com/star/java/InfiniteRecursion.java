package com.star.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;

/**
 * @Author: lcx
 * @Date: 2019/2/12 15:33
 * @Description:
 */

public class InfiniteRecursion {

    @Override
    public String toString() {
        // return "InfiniteRecursion address : " + this + "\n";
        return "InfiniteRecursion address : " + super.toString() + "\n";
    }


    public static void main(String[] args) {
        if ("-g".equals(args[0])) {
            System.out.println("goodbye");
        }

        List<InfiniteRecursion> infiniteRecursions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            infiniteRecursions.add(new InfiniteRecursion());
        }
        System.out.println(infiniteRecursions);
        // System.out.println(new InfiniteRecursion());

        String s = new String("aaa".getBytes());
        System.out.println(s);
        System.out.println("aaa".getBytes());
        char[] chars = new char[10];
        "555gggg".getChars(0, 3, chars, 0);
        System.out.println(chars);
        System.out.println("aaa".toCharArray());

        System.out.println("bAA".compareTo("aaa"));
        System.out.println("baa".contains("a"));

        System.out.println("aaBB".contentEquals("bb"));
        System.out.println("aaa".regionMatches(true, 0, "abb", 0, 2));
        System.out.println("aaa".startsWith("aaaa"));

        System.out.println("bbba".indexOf("a", 9));

        String a = "s\uD834\uDD1E";
        System.out.println(a == "hello");

        System.out.println(a.substring(0, 3) == "hel");
        System.out.println(a);
        System.out.println(a.length());
        System.out.println(a.codePointCount(0, a.length()));
        System.out.println(Integer.toHexString(a.codePointAt(1)).toUpperCase());

        Scanner scanner = new Scanner(System.in);
        // System.out.println("what is your name?");
        // String name = scanner.nextLine();
        // System.out.println("how old are you?");
        // int age = scanner.nextInt();
        // System.out.println("hello " + name + ", your age is " + age);

        // Console console = System.console();
        // String userName = console.readLine("name : ");
        // char[] password = console.readPassword("password : ");

        double num = 10000.0 / 3.0;
        System.out.printf("%,.2f", num);
        System.out.println();
        System.out.printf("%tT", new Date());

        String s1 = String.format("%,.2f", num);
        System.out.println();
        System.out.println(s1);

        System.out.printf("%1$s %2$tB %2$te, %2$tY", "Due date: ", new Date());
        System.out.println();
        System.out.printf("%s %tB %<te, %<tY", "Due date: ", new Date());
        System.out.println();
        try {
            Scanner scanner1 = new Scanner(Paths.get("myfile.txt"));
            PrintWriter printWriter = new PrintWriter("newFile.txt");
            while (scanner1.hasNextLine()) {
                // System.out.println(scanner1.nextLine());
                printWriter.print(scanner1.nextLine());
            }
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(System.getProperty("user.dir"));

        int[] b = new int[10];
        System.out.println(Arrays.toString(b));

        int[] lucyNums = {666, 1, 3, 5, 7, 8};
        int[] copoedLuckyNums = Arrays.copyOf(lucyNums, 2 * lucyNums.length);
        System.out.println(Arrays.toString(copoedLuckyNums));

        Arrays.sort(lucyNums);
        System.out.println(Arrays.toString(lucyNums));

        String[] stringArr = {"a1g212", "1dfdf", "zggg", "hhh"};
        Arrays.sort(stringArr);
        System.out.println(Arrays.toString(stringArr));

        System.out.println((int)(11 * 0.7));

        String[] newStringArr = Arrays.copyOf(stringArr, 2 * stringArr.length);
        System.out.println(Arrays.toString(newStringArr));

        // Arrays.fill(stringArr, 0);

        char[] charArr = new char[1];
        charArr[0] = '1';

        int[][] aa = { {1,2,3,4}, {5,6,7,8}, {12,23,34,56}};
        System.out.println(Arrays.deepToString(aa));

        Math.random();
    }
}
