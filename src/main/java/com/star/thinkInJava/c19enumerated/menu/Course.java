//: enumerated/menu/Course.java
package com.star.thinkInJava.c19enumerated.menu;

public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public static void main(String[] args) {
        Food.Appetizer[] appetizers = Food.Appetizer.values();
        for (Food.Appetizer app : appetizers) {
            System.out.println(app);
        }
        Food[] values = Course.APPETIZER.values;
        for (Food value : values) {
            System.out.println(value);
        }
    }

    public Food randomSelection() {
//        return Enums.random(values);
        return null;
    }

} ///:~
