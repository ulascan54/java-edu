package com.example.javase14;
//class
//enum
//annotation
//interface
public class StudyRecord {
    //Lombok annotation generate eder.
    //başka bir fikri daha var bellek tarafında.
    public static void main(String[] args) {
        var calisan1= new Calisan("1","kate austen","kate@example.com",1000,"tr1");
        var employee1= new Employee("1","kate austen","kate@example.com",1000,"tr1");
        //bu iki sınıf komple aynıdır

        System.out.println(calisan1);
        System.out.println(calisan1.fullName());//tek fark burda get yok ve yazımı daha kolay
        System.out.println(employee1);
        System.out.println(employee1.getFullName());

    }

}

// record ne işe yarar bu classı yaratmada

record Calisan(String identity, String fullName, String email, double salary, String iban){

}


class Employee{ // immutable class
    private final String identity;
    private final String fullName;
    private final String email;
    private final double salary;
    private final String iban;

    public Employee(String identity, String fullName, String email, double salary, String iban) {
        this.identity = identity;
        this.fullName = fullName;
        this.email = email;
        this.salary = salary;
        this.iban = iban;
    }

    public String getIdentity() {
        return identity;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public String getIban() {
        return iban;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "identity='" + identity + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", iban='" + iban + '\'' +
                '}';
    }
}