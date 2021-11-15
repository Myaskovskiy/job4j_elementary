package ru.job4j.streamapi;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MapToListTest {
    @Test
    public void mapToList() {
        MapToList mapToList = new MapToList();
        Integer[][] integers = {{1, 2, 3}, {1, 2, 3}};
        List<Integer> rsl = mapToList.mapToList(integers);
        List<Integer> expected = List.of(1, 2, 3, 1, 2, 3);
        assertThat(rsl, is(expected));
    }
}
