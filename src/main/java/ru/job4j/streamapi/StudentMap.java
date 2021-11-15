package ru.job4j.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    public Map<String, Student> studentMap(List<Student> students) {
        return students.stream()
                .collect(
                Collectors.toMap(
                        Student::getSurname,
                        student -> student,
                        (o1, o2) -> o1.getSurname().equals(o2.getSurname()) ? o1 : o2
                )
        );
    }
}
