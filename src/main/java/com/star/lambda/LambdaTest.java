package com.star.lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lichunxia on 2020-03-16 14:38
 */
public class LambdaTest {

    public static void main(String[] args) {
        Topic topic1 = new Topic();
        topic1.setId("1");
        topic1.setNames(Arrays.asList("111", "222"));
        Topic topic2 = new Topic();
        topic2.setId("1");
        topic2.setNames(Arrays.asList("5555", "222"));
        List<Topic> list = new ArrayList<>();
        list.add(topic1);
        list.add(topic2);
        Map<String, Set<String>> collect = list.stream()
                .collect(Collectors.groupingBy(Topic::getId,
                        Collectors.mapping(Topic::getNames, Collectors.collectingAndThen(Collectors.toSet(),
                                lists -> lists.stream().flatMap(List::stream)
                                        .collect(Collectors.toSet())))));
        System.out.println(collect);

        Integer num = 0X7FFFFFFF + 1;
        Long lnum = 0X7FFFFFFF + 1L;
        // num = lnum;
        System.out.println(num);
        System.out.println(lnum);
        Character character = 'A';
        System.out.println(Integer.valueOf(character));
        System.out.println(10.5 % 3);
        if (7 < 2) System.out.println(1);
        System.out.println(2);
    }
}
