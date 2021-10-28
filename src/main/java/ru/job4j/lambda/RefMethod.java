package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RefMethod {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr"
        );
        Consumer<String> consumer = System.out::println;
        names.forEach(consumer);
        names.forEach(System.out::println);
        names.forEach(o -> System.out.println(o));

        Consumer<String> out = (name) -> cutOut(name);
        Consumer<String> outNew = RefMethod::cutOut;
        names.forEach(outNew);
    }

    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10) + "..");
        } else {
            System.out.println(value);
        }
    }
}
