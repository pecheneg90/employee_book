package pro.sky.java.course2.employee_book.Service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.employee_book.Exception.EmployeeExist;
import pro.sky.java.course2.employee_book.Exception.EmployeeNotFound;
import pro.sky.java.course2.employee_book.Exception.EmployeesIsFull;
import pro.sky.java.course2.employee_book.Service.EmployeeService;
import pro.sky.java.course2.employee_book.data.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public String greetings() {
        return "Книга Сотрудников. В данной книге возможно добавлять, удалять и искать сотрудников!";
    }

    @Override
    public Employee add(String firstName, String lastName, String middleName,
                        int department, double salaryMonth) {
        Employee employee = new Employee(
                StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName),
                StringUtils.capitalize(middleName),
                department, salaryMonth);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeExist();
        }
        if (StringUtils.isNumeric(firstName)
                || StringUtils.isNumeric(lastName)
                || StringUtils.isNumeric(middleName)) {
            throw new EmployeeExist();
        }
        if (employees.size() == 5) {
            throw new EmployeesIsFull();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, String middleName,
                           int department, double salaryMonth) {
        Employee employee = new Employee(firstName, lastName, middleName, department, salaryMonth);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Employee find(String firstName, String lastName, String middleName,
                         int department, double salaryMonth) {
        Employee employee = new Employee(firstName, lastName, middleName, department, salaryMonth);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Collection<Employee> printAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}