package ru.job4j.lambda;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiapasonTest {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new ArrayList<>();
        for (int y = start; y <= end; y++) {
            res.add(func.apply((double) y));
        }
        return res;
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = diapason(5, 7, (x) -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = diapason(1, 3, (x) -> x * x);
        List<Double> expected = Arrays.asList(1D, 4D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = diapason(1, 3, (x) -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(1D, 4D, 27D);
        assertThat(result, is(expected));
    }
}
