package com.star.thinkInJava.c14TypeInformation;

class Food {
}

class Fruit extends Food {
}

class Apple extends Fruit {
}

class Plate<T> {
    private T item;

    public Plate(T t) {
        item = t;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public class GenericTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Plate<? extends Fruit> plate = new Plate<>(new Fruit());
//        plate.setItem(new Fruit());
        Fruit f = plate.getItem();
//        Apple apple = plate.getItem();
        Object obj = plate.getItem();

        Plate<? super Fruit> plate1 = new Plate<>(new Apple());
        plate1.setItem(new Apple());
        plate1.setItem(new Fruit());

//        Fruit f2 = plate1.getItem();
        Object obj2 = plate1.getItem();

        Class<Fruit> fruitClass = Fruit.class;
        Fruit fruit = fruitClass.newInstance();

        Class<? super Fruit> up = fruitClass.getSuperclass();

//        Class<Food> foodClass = fruitClass.getSuperclass();

        Food obj3 = (Food) up.newInstance();

    }
}
