package pro.sky.Homework29.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Homework29.skyprospringdemo.Employee;
import pro.sky.Homework29.skyprospringdemo.service.DepartmentService;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalaryFind(@RequestParam("departmentId") int departmentId) {
        return departmentService.minSalaryFind(departmentId);
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalaryFind(@RequestParam("departmentId") int departmentId) {
        return departmentService.maxSalaryFind(departmentId);
    }


    @GetMapping(path = "/all", params = "departmentId")
    public List<Employee> getEmployees(@RequestParam("departmentId") int departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getEmployeesGrouped();
    }
}