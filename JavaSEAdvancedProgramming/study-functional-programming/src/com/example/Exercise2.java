package com.example;

import java.util.List;
import java.util.function.Predicate;

import static com.example.LetterGrade.*;

public class Exercise2 {
    public static void main(String[] args) {
        var students = List.of(
                new Student("1", "jack bauer", List.of(AA, FF, CB, BB, CB)),
                new Student("2", "kate austen", List.of(AA, AA, BB, BA, CB)),
                new Student("3", "james sawyer", List.of(AA, FF, FF, BA, BA)),
                new Student("4", "jin kwon", List.of(AA, AA, BB, BB, CC)));

    }
}

