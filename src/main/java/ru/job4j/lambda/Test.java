package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
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
        System.out.println(test.empty(""));
        System.out.println(test.contains("1234", "12"));
        System.out.println(test.startWith("12345", "1"));
        System.out.println("test");
        System.out.println(test.check(str -> str.contains("12"), "12345"));
        System.out.println(test.check(str -> str.isEmpty(), ""));

    }
}
