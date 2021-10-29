package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        /**
        *(s, s1) -> map.put(s, s1);
        */
        BiConsumer<Integer, String> biCon = map::put;
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        int i = 1;
        for (String s : list) {
            biCon.accept(i, s);
            System.out.println(map.get(i++));
        }

        BiPredicate<Integer, String> biPred = (in, st) -> (in % 2 == 0 || st.length() == 4);
        for (Integer y : map.keySet()) {
            if (biPred.test(y, map.get(y))) {
                System.out.println("key: " + y + " value: " + map.get(y));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> strings = sup.get();
        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = (s) -> s.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}
