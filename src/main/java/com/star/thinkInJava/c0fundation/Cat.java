package com.star.thinkInJava.c0fundation;

public class Cat {
    private int height;
    private int weight;

    public Cat(int h, int w) {
        this.height = h;
        this.weight = w;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cat))
            return false;
        Cat c = (Cat) o;
        return c.height == height && c.weight == weight;
    }
}
