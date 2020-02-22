package com.star.thinkInJava.c12exceptions;

class SimpleException extends Exception {
}


public class InheritingException {

    public void sed() throws SimpleException {
        System.out.println("Throw SimpleException from sed ");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingException inheritingException = new InheritingException();

        try {
            inheritingException.sed();
        } catch (SimpleException e) {
            e.printStackTrace(System.err);
            System.out.println("caught it");
        }

        String a = null;
        try {
            a.length();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Integer.MAX_VALUE);
    }
}