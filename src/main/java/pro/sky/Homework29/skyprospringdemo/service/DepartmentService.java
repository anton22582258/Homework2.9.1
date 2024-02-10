package pro.sky.Homework29.skyprospringdemo.service;

import pro.sky.Homework29.skyprospringdemo.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee minSalaryFind(int departmentId);

    Employee maxSalaryFind(int departmentId);

    List<Employee> getEmployeesByDepartment(int departmentId);

    Map<Integer, List<Employee>> getEmployeesGrouped();
}





