package demo;

/*
    File Name : EmployeeComparator.java
    
    @author Mayank Sharma
    First Created on 13-10-2020 at 19:21
*/

import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {

    String name;
    Integer id;
    Integer rollNo;

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee(String name, Integer id, Integer rollNo) {
        this.name = name;
        this.id = id;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", rollNo=" + rollNo +
                '}';
    }
}

public class EmployeeComparator {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Mayank",1, 23));
        employees.add(new Employee("Mohit",2, 24));

        List<Employee> sortedList = employees.stream().sorted(Comparator.comparing(Employee::getId)
                .thenComparing(Employee::getName).thenComparing(Employee::getRollNo))
                .collect(Collectors.toList());

        System.out.println(employees);
    }

}
