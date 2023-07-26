package com.example;

import java.util.List;

import com.example.entity.Department;
import com.example.entity.Emplooyee;
import com.example.entity.Gender;

public class Exercise1 {
	public static void main(String[] args) {
		List<Emplooyee> employees = List.of(
				new Emplooyee("1", "jack", "bauer", 1956, 25_000, Gender.MALE, Department.HR),
				new Emplooyee("2", "kate", "austen", 1978, 35_000, Gender.FEMALE, Department.FINANCE),
				new Emplooyee("3", "jin", "kwon", 1976, 45_000, Gender.FEMALE, Department.MARKETING),
				new Emplooyee("4", "ben", "linus", 1954, 55_000, Gender.MALE, Department.IT),
				new Emplooyee("5", "sun", "kevin", 1973, 15_000, Gender.MALE, Department.SALES),
				new Emplooyee("6", "jesse", "james", 1980, 27_000, Gender.MALE, Department.IT));

		double totalSalary = employees.stream().map(employee -> employee.getSalary()).reduce(0.0,
				(sum, salary) -> sum + salary);
		// stream()
		// jack -> kate -> jin -> ben -> sun -> jesse
		// .map() : 25000 -> 4500 -> 55000 -> 15000 -> 27000
		// .reduce() : accumulator:202000
		// (0.0,2500) -> 25000
		// (sum, salary) -> sum + salary ......
		// (175000,27000) -> 202000
		// reduce() -> 202000 -> totalSalary

		System.out.println("Total salary is " + totalSalary + " \u20BA");

		double totalSalary2 = employees.stream().map(Emplooyee::getSalary).reduce(0.0, Double::sum);

		// Stream API methods:
		// i intermediary methods: ara methodlar , filter, map, distinct, limit, sorted,
		// boxed, ...
		// ii terminal methods: reduce, sum ,min , max ,findFirst, findAny, count,....
		// Lazy Evaluation : terminal method triggers processing

		long numberOfITMembers = employees.stream().filter(employee -> employee.getDepartment() == Department.IT).count();
		System.out.println("number of IT members :" + numberOfITMembers);
		
		long numberOfITMembers2 = employees.stream().map(Emplooyee::getDepartment).filter(Department.IT::equals).count();
		System.out.println("number of IT members :" + numberOfITMembers2);
	}

}
