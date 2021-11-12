package ru.job4j.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    public Map<String, Student> studentMap(List<Student> students) {
        return students.stream()
                .sorted((o1, o2) -> o1.getSurname().compareTo(o2.getSurname())).
                distinct().
                collect(
                Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student
                )
        );
    }
}
