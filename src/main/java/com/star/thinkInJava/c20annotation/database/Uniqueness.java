//: annotations/database/Uniqueness.java
// Sample of nested annotations
package com.star.thinkInJava.c20annotation.database;

public @interface Uniqueness {
    Constraints constraints()
            default @Constraints(unique = true);
} ///:~
