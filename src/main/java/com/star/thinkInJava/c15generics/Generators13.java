package com.star.thinkInJava.c15generics;

import java.util.*;

public class Generators13 {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) coll.add(gen.next());
        return coll;
    }

    public static <T> List<T> fill(List<T> l, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) l.add(gen.next());
        return l;
    }

    public static <T> Queue<T> fill(Queue<T> q, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) q.add(gen.next());
        return q;
    }

    public static <T> Set<T> fill(Set<T> s, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) s.add(gen.next());
        return s;
    }

    // return type LinkedList:
    public static <T> LinkedList<T> fill(LinkedList<T> ll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) ll.add(gen.next());
        return ll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee) System.out.println(c);
//        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(1), 12);
//        for(int i : fnumbers) System.out.print(i + ", ");
        System.out.println();
        List<Coffee> coffeeList = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 5);
        System.out.println("List type: " + coffeeList.getClass());
        System.out.println("coffeeList:" + coffeeList);
        Queue<Coffee> coffeeQueue = fill(new ArrayDeque<Coffee>(), new CoffeeGenerator(), 5);
        System.out.println("Queue type: " + coffeeQueue.getClass());
        System.out.println("coffeeQueue: " + coffeeQueue);
        Set<Coffee> coffeeSet = fill(new HashSet<Coffee>(), new CoffeeGenerator(), 5);
        System.out.println("Set type: " + coffeeSet.getClass());
        System.out.println("coffeeSet: " + coffeeSet);
        LinkedList<Coffee> coffeeLinkedList = fill(new LinkedList<Coffee>(), new CoffeeGenerator(), 5);
        System.out.println("LinkedList type: " + coffeeLinkedList.getClass());
        System.out.println("coffeeLinkedList: " + coffeeLinkedList);

    }
}
