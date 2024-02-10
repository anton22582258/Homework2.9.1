package pro.sky.Homework29.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.Homework29.skyprospringdemo.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee minSalaryFind(int departmentId) {

        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Employee maxSalaryFind(int departmentId) {

        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return employeeService.getAll().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getEmployeesGrouped() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}