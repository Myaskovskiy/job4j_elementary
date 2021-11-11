package ru.job4j.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> res = arrayList.stream().filter(
                x -> x % 2 == 0
        ).collect(Collectors.toList());
        res.forEach(System.out::println);
    }
}
