package com.star.thinkInJava.c15generics;//: generics/UseList.java
// {CompileTimeError} (Won't compile)

import java.util.List;

public class UseList<W, T> {
    void f1(List<T> v) {
    }

    void f(List<W> v) {
    }
} ///:~
