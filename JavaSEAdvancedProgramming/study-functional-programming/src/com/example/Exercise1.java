package com.example;

import java.util.List;
import java.util.function.Predicate;

import static com.example.LetterGrade.*;

public class Exercise1 {
    public static void main(String[] args) {
        var students = List.of(
                new Student("1", "jack bauer", List.of(AA, FF, CB, BB, CB)),
                new Student("2", "kate austen", List.of(AA, AA, BB, BA, CB)),
                new Student("3", "james sawyer", List.of(AA, FF, FF, BA, BA)),
                new Student("4", "jin kwon", List.of(AA, AA, BB, BB, CC)));
        Predicate<Student> hasAtLeastOneFF = student -> student.grades().stream().anyMatch(LetterGrade.FF::equals);

        var failedStudents = students.stream()
                .filter(hasAtLeastOneFF)
                .toList();

        var successfulStudents = students.stream()
                .filter(hasAtLeastOneFF.negate())
                .toList();
        System.out.println("======Failed Students======");
        failedStudents.forEach(System.out::println);
        System.out.println("======Successful Students======");
        successfulStudents.forEach(System.out::println);
    }
}

