package com.star.thinkInJava.c11holding;

import java.awt.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class GreenHouseController {

    // A class from java.util to hold Event objects:
    private LinkedList<Event> eventList = new LinkedList<Event>();

    static void addMiddle(LinkedList<Integer> l, Integer[] ia) {
        for (Integer i : ia) {
//            ListIterator<Integer> it = l.listIterator(l.size() / 2);
            ListIterator<Integer> it = l.listIterator(l.size() >> 1);
            it.add(i);
//            l.add(l.size() / 2, i);
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> li = new LinkedList<>();
        Integer[] x = {0, 1, 2, 3, 4, 5, 6, 7};
        addMiddle(li, x);
    }

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        LinkedList<Event> eventListCopy = new LinkedList<Event>(eventList);
        ListIterator<Event> it = eventListCopy.listIterator();
        while (it.hasNext()) {
//            it.next().action();
            it.previous();
            System.out.println(it.next());
        }
    }

}
