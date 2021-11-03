package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TestDiapason {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new ArrayList<>();
        for (int y = start; y < end; y++) {
            res.add(func.apply((double) y));
        }
        return res;
    }
}
