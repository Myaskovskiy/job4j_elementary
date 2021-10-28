package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("111");
        Comparator<String> cmpText = (o1, o2) -> {
            System.out.println("compare text - " + o1 + " and " + o2);
            return o1.compareTo(o2);
        };
        Comparator<String> cmpDescSize = (o1, o2) -> {
            System.out.println("compare size - " + o1 + " and " + o2);
            return Integer.compare(o2.length(), o1.length());
        };
        strings.sort(cmpText);
        System.out.println(strings);
        strings.sort(cmpDescSize);
        System.out.println(strings);
    }
}
