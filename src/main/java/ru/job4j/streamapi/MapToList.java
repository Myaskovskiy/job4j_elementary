package ru.job4j.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapToList {
    public List<Integer> mapToList(Integer[][] integers) {
         return Stream.of(integers)
                 .flatMap(Stream::of)
                 .collect(Collectors.toList());
    }
}
