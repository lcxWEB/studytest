package com.star.thinkInJava.c8polymorphism;

import static com.star.thinkInJava.c11holding.SetOperations.print;

public class PrivateOverride {
    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
        Derived de = new Derived();
        de.f();
    }

    private void f() {
//    protected void f() {
//    public void f() {
        print("private f()");
    }

}

class Derived extends PrivateOverride {
    public void f() {
        print("public f()===");
    }
}
