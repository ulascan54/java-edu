package com.example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import static com.example.LetterGrade.*;

public class Introduction {
    public static void main(String[] args) {
        var students = List.of(
                new Student("1", "jack bauer", List.of(AA, FF, CB, BB, CB)),
                new Student("2", "kate austen", List.of(AA, AA, BB, BA, CB)),
                new Student("3", "james sawyer", List.of(AA, FF, FF, BA, BA)),
                new Student("4", "jin kwon", List.of(AA, AA, BB, BB, FF))
        );
        //Outer Loop
        //Traditional way
        for (var student : students) {
            var averageGrade = calculateAverageGrade(student);
            System.out.println("%11s %16s %2.1f".formatted(student.identity(), student.fullName(), averageGrade));
        }

        // Functional Programming + Stream API -> Collection: Filter/Map/Reduce
        //Inner Loop
        //Long Way
        students.stream()
                .map(
                        new Function<Student, StudentGrade>() {
                            @Override
                            public StudentGrade apply(Student student) {
                                var grade = student.grades().stream()
                                        .mapToInt(new ToIntFunction<LetterGrade>() {

                                    @Override
                                    public int applyAsInt(LetterGrade grade) {
                                        return grade.getValue();
                                    }
                                }).average();
                                return new StudentGrade(student.fullName(), grade.getAsDouble());
                            }
                        }
                ).forEach(new Consumer<StudentGrade>() {
                    @Override
                    public void accept(StudentGrade studentGrade) {
                        System.out.println(studentGrade.fullName()+":"+studentGrade.grade());
                    }
                });
        // with Lambda expression

        students.stream()
                //.parallel() //Fork-Join Framework (Java SE 7)
                .map(student -> {
                    var avgGrade = student.grades().stream().mapToInt(LetterGrade::getValue).average();
                    return new StudentGrade(student.fullName(),avgGrade.getAsDouble());
                })
                .forEach(studentGrade -> System.out.println(studentGrade.fullName() + ": "+studentGrade.grade()));

    }

    private static double calculateAverageGrade(Student student) {
        return getGradeSum(student) / student.grades().size();
    }

    private static double getGradeSum(Student student) {
        var averageGrade = 0.0;
        for (var grade : student.grades()) {
            averageGrade += grade.getValue();
        }
        return averageGrade;
    }
}


enum LetterGrade {
    AA(10), BA(9), BB(8), CB(7), CC(6), DC(5), DD(4), FF(0);
    private final int value;


    private LetterGrade(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

record StudentGrade(String fullName, double grade) {
}

record Student(String identity, String fullName, List<LetterGrade> grades) {

}
