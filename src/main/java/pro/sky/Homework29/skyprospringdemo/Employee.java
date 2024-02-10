package pro.sky.Homework29.skyprospringdemo;

import java.util.Objects;

public class Employee implements Comparable {

    private String firstName;
    private String lastName;
    private final double salary;
    private final int department;

    public Employee(String firstName, String lastName, double salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "{<br>" +
                "\"lastName\"=\"" + lastName + "\"," +
                "<br>\"firstname\"=\"" + firstName + "\"," +
                "<br>\"departmentId\"=\"" + department + "\"," +
                "<br>\"salary\"=\"" + salary + "\"<br>" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && department == employee.department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }


    @Override
    public int compareTo(Object o) {
        Employee e = (Employee) o;
        if (this.salary > e.getSalary()) {
            return 1;
        } else if (this.salary < e.getSalary()) {
            return -1;
        }
        return 0;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


