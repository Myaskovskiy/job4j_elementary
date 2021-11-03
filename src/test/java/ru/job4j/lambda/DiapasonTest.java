package ru.job4j.lambda;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiapasonTest {

    TestDiapason testDiapason = new TestDiapason();

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = testDiapason.diapason(5, 8, (x) -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = testDiapason.diapason(1, 4, (x) -> x * x);
        List<Double> expected = Arrays.asList(1D, 4D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = testDiapason.diapason(1, 4, (x) -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D);
        assertThat(result, is(expected));
    }
}
