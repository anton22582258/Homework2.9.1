package pro.sky.Homework29.skyprospringdemo.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.Homework29.skyprospringdemo.Employee;
import pro.sky.Homework29.skyprospringdemo.exception.EmployeeAlreadyAddedInListException;
import pro.sky.Homework29.skyprospringdemo.exception.EmployeeNotFoundException;
import pro.sky.Homework29.skyprospringdemo.exception.EmployeeStorageIsFullException;
import pro.sky.Homework29.skyprospringdemo.exception.InvalidDataException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int SIZE_LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap<>(SIZE_LIMIT);

    public Collection<Employee> getAll() {

        return employees.values();
    }

    public String createKey(String firstName, String lastName) {

        return firstName + lastName;
    }


    public Employee add(String firstName, String lastName, double salary, int department) throws EmployeeAlreadyAddedInListException {
        Employee employee = employees.get(createKey(firstName, lastName));
        {
            if (!StringUtils.isAlpha(employee.getFirstName())
                    || !StringUtils.isAlpha(employee.getLastName())) {
                throw new InvalidDataException();
            }
            if (employees.size() >= SIZE_LIMIT) {
                throw new EmployeeStorageIsFullException("ArrayIsFull");
            }
            if (employees.containsKey(createKey(firstName, lastName))) {
                throw new EmployeeAlreadyAddedInListException("Employee is already exist");
            }
            String correctedFirstName = StringUtils.capitalize(employee.getFirstName().toLowerCase());
            employee.setFirstName(correctedFirstName);
            String correctedLastName = StringUtils.capitalize(employee.getLastName().toLowerCase());
            employee.setLastName(correctedLastName);
            employees.put(createKey(firstName, lastName), employee);
            return employee;
        }
    }


    public Employee remove(String firstName, String lastName, double salary, int department) throws EmployeeNotFoundException {
        Employee employee = employees.get(createKey(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return employees.remove(createKey(firstName, lastName));
    }

    public Employee find(String firstName, String lastName, double salary, int department) throws EmployeeNotFoundException {
        Employee employee = employees.get(createKey(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
        return employee;
    }

}




