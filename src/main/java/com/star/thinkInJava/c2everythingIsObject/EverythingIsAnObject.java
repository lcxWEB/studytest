package com.star.thinkInJava.c2everythingIsObject;

public class EverythingIsAnObject {

    private String s;

    private char chars;

    private int i;

    /**
     *
     */
    public void test() {
//        s.charAt(0);
        System.out.println(chars);
        System.out.println(i);
    }


    /*
     main函数
     */
    public static void main(String[] args) {
        EverythingIsAnObject e = new EverythingIsAnObject();
        e.test();

        String a = "asdf";
        String b = new String("asdf");
        String c = "asdf";
        String d = new String("asdf");

        System.out.println(a == b);
        System.out.println(a.equalsIgnoreCase(b));
        System.out.println(a.equals(b));

        System.out.println(a == c);
        System.out.println(a.equals(c));

        System.out.println(b == d);


        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Integer.valueOf(Character.MIN_VALUE));
        System.out.println(Integer.valueOf(Character.MAX_VALUE));


        int[] arr = new int[0];
        System.out.println(arr);

        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }
}
