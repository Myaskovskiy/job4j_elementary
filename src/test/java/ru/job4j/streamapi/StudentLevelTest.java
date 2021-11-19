package ru.job4j.streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = List.of(
        new Student(28, "Masha"),
        new Student(128, "Pety")
        );
        List<Student> expected = List.of(
                new Student(28, "Masha"),
                new Student(128, "Pety")
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = List.of(
        null,
        new Student(128, "Pety"));
        List<Student> expected = List.of(new Student(128, "Pety"));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }
}
