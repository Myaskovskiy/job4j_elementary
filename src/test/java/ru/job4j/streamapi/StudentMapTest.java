package ru.job4j.streamapi;

import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentMapTest {
    @Test
    public void whenCollectStudent() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4")
        );
        StudentMap studentMap = new StudentMap();
        Map<String, Student> rsl = studentMap.studentMap(students);
        Map<String, Student> expected = Map.of(
        "Surname1", new Student(10, "Surname1"),
        "Surname4", new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectStudentDublicat() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(40, "Surname4")
        );
        StudentMap studentMap = new StudentMap();
        Map<String, Student> rsl = studentMap.studentMap(students);
        Map<String, Student> expected = Map.of(
                "Surname1", new Student(10, "Surname1"),
                "Surname4", new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }
}
