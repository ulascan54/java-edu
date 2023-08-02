package com.example;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class StudyPureFunctions {

    public static void main(String[] args) {
        var numbers = List.of(4, 8, 15, 16, 23, 42);
        var localState = 108; //final : effectively final
        Predicate<Integer> ifEven = n -> {
            var x =localState;
            x++;
            return n % 2 == 0;
        };
        ToDoubleFunction<? super Integer> toCube = x -> x * x * x;

        var solution = numbers.stream()
                .filter(ifEven)//high order function
                .mapToDouble(toCube)//high order function
                .sum();
        System.out.println(solution);
    }


}
