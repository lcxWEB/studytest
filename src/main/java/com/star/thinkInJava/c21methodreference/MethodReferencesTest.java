package com.star.thinkInJava.c21methodreference;

import io.lettuce.core.output.KeyStreamingChannel;
import jdk.management.resource.ResourceId;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReferencesTest {

    // The method transferElements copies elements from one collection to
    // another

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST
    transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory) {
        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static void main(String... args) {

        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());

        List<Person> roster = Person.createRoster();

        for (Person p : roster) {
            p.printPerson();
        }


        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);

        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        // Without method reference
        Arrays.sort(rosterAsArray, new PersonAgeComparator());

        // With lambda expression
        Arrays.sort(rosterAsArray,
                (Person a, Person b) -> {
                    return a.getBirthday().compareTo(b.getBirthday());
                }
        );

        // With method reference
        Arrays.sort(rosterAsArray, Person::compareByAge);

        // Reference to an instance method of a particular object
        class ComparisonProvider {
            public int compareByName(Person a,
                                     Person b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a,
                                    Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }
        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);

        // Reference to an instance method
        // of an arbitrary object of a particular type
        String[] stringArray = {"Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda"};
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        Set<Person> rosterSetLambda =
                transferElements(roster, () -> {
                    return new HashSet<>();
                });

        Set<Person> rosterSet = transferElements(roster, HashSet::new);
        System.out.println("Printing rosterSet:");
        rosterSet.stream().forEach(p -> p.printPerson());
        // System.out.println(rosterSet);
        Map<String, Person> map = rosterSet.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
        // System.out.println(map);
        Map<String, Set<Person>> collect = rosterSet.stream().collect(Collectors.groupingBy(Person::getName, Collectors.toSet()));
        // System.out.println(collect);


        // 顺序流和并行流比较
        long t0 = System.nanoTime();

        //初始化一个范围100万整数流,求能被2整除的数字，toArray（）是终点方法

        int a[]= IntStream.range(0, 200_000_000).filter(p -> p % 2==0).toArray();

        long t1 = System.nanoTime();

        //和上面功能一样，这里是用并行流来计算
        int b[]=IntStream.range(0, 200_000_000).parallel().filter(p -> p % 2==0).toArray();
        long t2 = System.nanoTime();
        //我本机的结果是serial: 0.06s, parallel 0.02s，证明并行流确实比顺序流快

        System.out.printf("serial: %.2fs, parallel %.2fs%n", (t1 - t0) * 1e-9, (t2 - t1) * 1e-9);

    }

    public void lambdaTest(Set<Person> personSet) {
        personSet.stream().forEach(person -> person.setName("222"));

        Function<String, Integer> channel = s -> s.length();

        Predicate<String> predicte = (String s) -> s.equals("1");
        IntSupplier supplier = () -> 42;

        BiFunction<String, Integer, Character> stringIntegerCharacterBiFunction = String::charAt;
        System.out.println(stringIntegerCharacterBiFunction.apply("2222", 2));
        Function<String, Person> personFunction = Person::new;
        Person person = personFunction.apply("sdsdsds");
    }

}