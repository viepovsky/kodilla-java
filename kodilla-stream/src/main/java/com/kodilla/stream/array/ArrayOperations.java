package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static java.lang.Double.parseDouble;
import static java.util.stream.IntStream.range;

public interface ArrayOperations {
    static double getAverage(int[] numbers){
        IntStream.range(0,numbers.length)
                .forEach(n-> System.out.println(numbers[n]));
        return IntStream.range(0,numbers.length)
                .map(n -> numbers[n])
                .average().getAsDouble();
    }
}
