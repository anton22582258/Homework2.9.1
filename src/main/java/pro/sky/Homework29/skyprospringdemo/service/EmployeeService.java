package pro.sky.Homework29.skyprospringdemo.service;

import pro.sky.Homework29.skyprospringdemo.Employee;
import pro.sky.Homework29.skyprospringdemo.exception.EmployeeAlreadyAddedInListException;
import pro.sky.Homework29.skyprospringdemo.exception.EmployeeNotFoundException;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String lastName, double salary, int department) throws EmployeeAlreadyAddedInListException;

    Employee remove(String firstName, String lastName, double salary, int department) throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName, double salary, int department) throws EmployeeNotFoundException;

    Collection<Employee> getAll();

    String createKey(String firstName, String lastName);

}






