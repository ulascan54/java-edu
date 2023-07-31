package com.example.javase13;

public class StudyTextBlock {
    public static void main(String[] args) {
        var employeeAsJson = """
                {
                    "name":"jack bauer",
                    "identity:"11111",
                    "salary":1000,
                    "iban":"tr1"
                }
                """;
        System.out.println(employeeAsJson);
        var selectEmployee = """
                select * from employees e
                where e.salary > ?1
                """;
        System.out.println(selectEmployee);
    }
}
