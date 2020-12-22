package com.star.thinkInJava.c17containersindepth;

import java.util.*;

/**
 * Created by lichunxia on 2020-02-24 11:20
 */
public class IteratorTest {

    public static void main(String[] args) {
        // Create a link list which stores integer elements
        List<Integer> l = new LinkedList<Integer>();

        // Now add elements to the Link List
        l.add(2);
        l.add(3);
        l.add(4);

        // Make another Link List which stores integer elements
        List<Integer> s=new LinkedList<Integer>();
        s.add(7);
        s.add(8);
        s.add(9);

        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // List<Integer> list = arrayList.subList(0, 1);
        // list.remove(0);
        // System.out.println(list);
        ListIterator<Integer> listIterator = arrayList.listIterator();
        listIterator.hasPrevious();

        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        // for (String str : list) {
        //     if (str.equals("a"))
        //         list.remove(str);
        // }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("a")) {
                iterator.remove();
            }
        }

        // List<String> list = new ArrayList<>();
        // list.add("1");
        // list.add("2");
        // for (String item : list) {
        //     if ("1".equals(item)) {
        //     // if ("2".equals(item)) {
        //         list.remove(item);
        //     }
        // }
        System.out.println(list);

        // Iterator to iterate over a Link List
        for (Iterator<Integer> itr1 = l.iterator(); itr1.hasNext(); )
        {
            for (Iterator<Integer> itr2=s.iterator(); itr2.hasNext(); )
            {
                if (itr1.next() < itr2.next())
                {
                    System.out.println(itr1.next());
                }
            }
        }
    }
}
