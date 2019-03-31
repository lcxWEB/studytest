package com.star.thinkInJava.c7reusingclass;

import static com.star.thinkInJava.c11holding.SetOperations.print;

class Cleanser {
    private String s = "Cleanser";

    protected static String CS = "CS=====";

    Cleanser() {
        System.out.println("Cleanser()===");
    }

    Cleanser(int i) {
        System.out.println("Cleanser()==i==");
    }


    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        print(x.toString());
    }

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }
}


public class Detergent extends Cleanser {

//    Detergent() {
//        System.out.println("Detergent()");
//    }

    Detergent(int i) {
        System.out.println("Detergent() " + i);
    }
    // Test the new class:
    public static void main(String[] args) {
        System.out.println(Detergent.CS);
//        Detergent x = new Detergent();
        Detergent x = new Detergent(1);
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x.toString());
        print("Testing base class:");
        Cleanser.main(args);
    }

    // Change a method:
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); // Call base-class version
    }

    // Add methods to the interface:
    public void foam() {
        append(" foam()");
    }

}
