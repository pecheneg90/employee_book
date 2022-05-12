package pro.sky.java.course2.employee_book.Service.impl;

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
    public Employee add(String firstName, String lastName, String middleName) {
        Employee employee = new Employee(firstName, lastName, middleName);
        if (employees.containsKey(lastName + firstName + middleName)) {
            throw new EmployeeExist();
        }
        if (employees.size() == 3) {
            throw new EmployeesIsFull();
        }
        employees.put(firstName + lastName + middleName, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, String middleName) {
        Employee employee = new Employee(firstName, lastName, middleName);
        if (employees.containsKey(firstName + lastName + middleName)) {
            return employees.remove(firstName + lastName + middleName);
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Employee find(String firstName, String lastName, String middleName) {
        Employee employee = new Employee(firstName, lastName, middleName);
        if (employees.containsKey(firstName + lastName + middleName)) {
            return employees.get(firstName+lastName+middleName);
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Collection<Employee> printAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}