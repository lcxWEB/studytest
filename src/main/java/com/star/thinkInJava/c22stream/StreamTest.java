package com.star.thinkInJava.c22stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lichunxia on 2020-02-24 17:24
 */
public class StreamTest {

    public static void main(String[] args) {
        Arrays.asList("How are you", "Hello", "Tom", "Hi", "Hell", "Jerry")
                .stream()
                .filter(s -> s.startsWith("H"))
                .map(s -> s.substring(2))
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        Arrays.asList("How are you", "I have a dog", "Hi boy", "cat dog", "boy")
                .stream()
                .map(s -> s.split(" "))
                .flatMap(Stream::of)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
