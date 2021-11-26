package ru.job4j.certificat;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> list) {
        return list
                .flatMap(e -> e.getSubjects().stream())
                .mapToInt(e -> e.getScore())
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
         return stream.map(e -> new Tuple(e.getName(),
                        e.getSubjects()
                         .stream()
                         .mapToInt(s -> s.getScore())
                         .average()
                         .orElse(0D)))
                         .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(e -> e.getSubjects()
                .stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(e -> new Tuple(e.getName(), e.getSubjects()
                .stream()
                .mapToInt(s -> s.getScore())
                .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(e -> e.getSubjects()
                .stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList())
                .stream()
                .max(Comparator.comparing(Tuple::getScore))
                .get();
    }
}
