package com.example;

import java.util.List;

import com.example.entity.Department;
import com.example.entity.Emplooyee;
import com.example.entity.Gender;

public class Exercise1 {
	public static void main(String[] args) {
		List<Emplooyee> employess = List.of(
				new Emplooyee("1", "jack", "bauer", 1956, 25_000, Gender.MALE, Department.HR),
				new Emplooyee("2", "kate", "austen", 1978, 35_000, Gender.FEMALE, Department.FINANCE),
				new Emplooyee("3", "jin", "kwon", 1976, 45_000, Gender.FEMALE, Department.MARKETING),
				new Emplooyee("4", "ben", "linus", 1954, 55_000, Gender.MALE, Department.IT),
				new Emplooyee("5", "sun", "kevin", 1973, 15_000, Gender.MALE, Department.SALES),
				new Emplooyee("6", "jesse", "james", 1980, 27_000, Gender.MALE, Department.IT));
	}

}
