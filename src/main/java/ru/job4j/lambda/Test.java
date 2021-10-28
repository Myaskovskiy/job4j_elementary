package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Test {

        public boolean empty(String s) {
        return s.isEmpty();
        }

        public boolean startWith(String s, String pref) {
        return s.startsWith(pref);
        }

        public boolean contains(String s, String key) {
        return s.contains(key);
        }

        public boolean check(Predicate<String> pr, String s) {
            return pr.test(s);
        }

    public static void main(String[] args) {
        Test test = new Test();
        List<String> strings = Arrays.asList("111", "2222", "4", "33333");
        Comparator<String> cmpText = (o1, o2) -> o1.compareTo(o2);
        Comparator<String> cmpDescSize = (o1, o2) -> Integer.compare(o2.length(), o1.length());
        strings.sort(cmpText);
        System.out.println(strings);
        strings.sort(cmpDescSize);
        System.out.println(strings);
        System.out.println(test.empty(""));
        System.out.println(test.contains("1234", "12"));
        System.out.println(test.startWith("12345", "1"));
        System.out.println("test");
        System.out.println(test.check(str -> str.contains("12"), "12345"));
        System.out.println(test.check(str -> str.isEmpty(), ""));
    }
}
