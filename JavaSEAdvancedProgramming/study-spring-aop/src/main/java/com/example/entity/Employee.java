package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    private String identity;
    private String fullName;
    private String iban;
    private double salary;


    public Employee() {
    }

    @PrePersist
    public void setMinSalary(){
        salary = 10_000;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "identity='" + identity + '\'' +
                ", fullName='" + fullName + '\'' +
                ", iban='" + iban + '\'' +
                ", salary=" + salary +
                '}';
    }
}
