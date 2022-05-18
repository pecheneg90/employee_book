package pro.sky.java.course2.employee_book.Service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employee_book.Exception.EmployeeNotFound;
import pro.sky.java.course2.employee_book.Service.DepartmentService;
import pro.sky.java.course2.employee_book.Service.EmployeeService;
import pro.sky.java.course2.employee_book.data.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee minSalaryMonth(int department) {
        Optional<Employee> employeeMinSalary = employeeService.printAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalaryMonth));
        if (employeeMinSalary.isPresent()) {
            return employeeMinSalary.get();
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Employee maxSalaryMonth(int department) {
        Optional<Employee> employeeMaxSalary = employeeService.printAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalaryMonth));
        if (employeeMaxSalary.isPresent()) {
            return employeeMaxSalary.get();
        }
        throw new EmployeeNotFound();
    }

    @Override
    public List<Employee> departmentAll(Integer department) {
        if (department == null) {
            return employeeService.printAllEmployees().stream()
                    .sorted(Comparator.comparingInt(Employee::getDepartment))
                    .collect(Collectors.toList());
        }
        return employeeService.printAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }
}