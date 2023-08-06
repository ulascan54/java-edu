package com.example;

import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {
        //I. "Functional Requirements
        //1. duplicate 2.ordered -> can sortable
        List<Integer> numbers = new ArrayList<>();
        numbers.add(42);
        numbers.add(42);
        numbers.add(42);
        System.out.println(numbers);
        System.out.println(numbers.get(1));
        numbers.add(1,8);// low performance
        System.out.println(numbers);
        System.out.println(numbers.get(1));
        numbers.sort(Integer::compare);
        System.out.println(numbers);
        System.out.println(numbers.contains(108));// low performance
        // i.unique 2. unordered -> cannot sort
        Set<Integer> sayilar = new HashSet<>();
        sayilar.add(42);
        sayilar.add(42);
        sayilar.add(42);
        sayilar.add(42);
        System.out.println(sayilar);
        Comparator<Employee> orderBySalaryDesc = (emp1,emp2)->{
            if(emp1.getSalary()>emp2.getSalary())
                return -1;
            return +1;
        };
        Set<Employee> employees = new TreeSet<>(orderBySalaryDesc.reversed());//order by salary
        employees.add(new Employee("1","jackbauer",10_000));
        employees.add(new Employee("1","jackbauer",10_000));
        employees.add(new Employee("1","jackbauer",10_000));
        employees.add(new Employee("1","jackbauer",10_000));
        employees.add(new Employee("1","jackbauer",10_000));
        employees.add(new Employee("1","jackbauer",10_000));
        employees.add(new Employee("1","jackbauer",10_000));
        employees.add(new Employee("2","jhin",10_000));
        employees.add(new Employee("3","kate",70_000));
        employees.add(new Employee("4","sun",40_000));
        employees.add(new Employee("5","ben",50_000));
        employees.add(new Employee("6","linus",30_000));
        employees.add(new Employee("7","austen",20_000));
        System.out.println(employees.size());
        System.out.println(employees.contains(new Employee("1","jackbauer")));
        //System.out.println(employees.get !!!!);
        employees.forEach(System.err::println);
        //3.Map -> 1. KEY->VALUE
        var areaCodes = new HashMap<>();
        areaCodes.put("istanbul-anadolu",216);
        areaCodes.put("istanbul-avrupa",216);
        areaCodes.put("ankara",321);
        System.out.println(areaCodes.get("ankara"));
        var quiz = new IdentityHashMap<Integer,String>();//->hashmap result -> 2
        quiz.put(42,"forty-two");//1
        quiz.put(42,"forty-two");//1
        quiz.put(549,"five-hundred-and-forty-nine");//2
        quiz.put(549,"five-hundred-and-forty-nine");//3
        System.out.println(quiz.size());
    }
}

class Employee implements Comparable<Employee>{//sort etmek için
    private String identity;
    private String fullName;
    private int salary;

    public Employee(String identity, String fullName, int salary) {
        this.identity = identity;
        this.fullName = fullName;
        this.salary = salary;
    }

    public Employee(String identity, String fullName) {
        this.identity = identity;
        this.fullName = fullName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(identity, employee.identity) && Objects.equals(fullName, employee.fullName);
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity, fullName);
    }

    @Override
    public int compareTo(Employee o) {
        return this.fullName.compareTo(o.fullName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "identity='" + identity + '\'' +
                ", fullName='" + fullName + '\'' +
                ", salary=" + salary +
                '}';
    }
}