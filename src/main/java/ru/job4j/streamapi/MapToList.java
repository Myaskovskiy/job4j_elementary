package ru.job4j.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapToList {
    public List<Integer> mapToList(Integer[][] integers) {
         return Arrays.stream(integers).flatMap(e -> Stream.of(e)).collect(Collectors.toList());
    }
}
