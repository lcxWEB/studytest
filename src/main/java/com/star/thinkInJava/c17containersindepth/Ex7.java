package com.star.thinkInJava.c17containersindepth;

import java.util.*;

public class Ex7 {
    public static void main(String[] args) {
        List<String> al = new ArrayList<String>(Countries.names(11));
        List<String> ll = new LinkedList<String>(Countries.names(10));
        ((LinkedList<String>) ll).addFirst("test");

        System.out.println("al : " + al);
        System.out.println("ll : " + ll);

        Iterator alit = al.iterator();
        Iterator llit = ll.iterator();
        while (alit.hasNext()) {
            System.out.print(alit.next() + (alit.hasNext() ? ", " : ""));
        }
        System.out.println();
        while (llit.hasNext()) {
            System.out.print(llit.next() + (llit.hasNext() ? ", " : ""));
        }

        System.out.println();
        System.out.println();

        ListIterator allit = al.listIterator();
        ListIterator lllit = ll.listIterator();

        while (lllit.hasNext()) {
            allit.add((String) lllit.next());
//            allit.next();
        }
        System.out.println(al);
        System.out.println();

        List<String> al2 = new ArrayList<String>(Countries.names(25));
        ListIterator allit2 = al2.listIterator();

        while (lllit.hasPrevious()) lllit.previous();
        while (allit2.hasNext()) allit2.next();
        while (lllit.hasNext()) {
            allit2.add((String) lllit.next());
            allit2.previous();
            allit2.previous();
        }
        System.out.println(al2);
    }
}
