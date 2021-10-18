package ru.job4j;

import org.junit.Test;
import ru.job4j.tdd.TestAdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainTest {
    @Test
    public void whenActionThenResult() {
        TestAdd testAdd = new TestAdd();
        int excepted = testAdd.add(1, 1);
        int result = 2;
        assertThat(result, is(excepted));
    }
}
