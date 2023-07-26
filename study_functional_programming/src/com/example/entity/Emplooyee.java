package com.example.entity;

public class Emplooyee {
	private String identity;
	private String firstName;
	private String lastName;
	private int birthYear;
	private double salary;
	private Gender gender;
	private Department department;

	public Emplooyee(String identity, String firstName, String lastName, int birthYear, double salary, Gender gender,
			Department department) {
		this.identity = identity;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.salary = salary;
		this.gender = gender;
		this.department = department;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Emplooyee [identity=" + identity + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthYear=" + birthYear + ", gender=" + gender + ", department=" + department + "]";
	}
	
	
}
