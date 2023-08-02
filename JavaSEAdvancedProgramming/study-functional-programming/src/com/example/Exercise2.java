package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.example.LetterGrade.*;

public class Exercise2 {
    public static void main(String[] args) {
        var students = List.of(
                new Student("1", "jack bauer", List.of(AA, FF, CB, BB, CB)),
                new Student("2", "kate austen", List.of(AA, AA, BB, AA, CB)),
                new Student("3", "james sawyer", List.of(AA, FF, FF, BA, BA)),
                new Student("4", "jin kwon", List.of(AA, AA, BB, AA, CC)));
        Function<Student,Long> extractNumberOfAAs=
                student -> student.grades().stream().filter(LetterGrade.AA::equals).count();
        Function<Student,Double> extractAverageGrade=
                student -> student.grades().stream().mapToInt(LetterGrade::getValue).average().getAsDouble();
        students.stream()
                .max(Comparator.comparing(extractNumberOfAAs).thenComparing(extractAverageGrade))
                .ifPresent(System.out::println);
    }
}

