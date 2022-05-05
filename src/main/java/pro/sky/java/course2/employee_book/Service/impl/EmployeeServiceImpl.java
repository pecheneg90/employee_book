package pro.sky.java.course2.employee_book.Service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employee_book.Exception.EmployeeExist;
import pro.sky.java.course2.employee_book.Exception.EmployeeNotFound;
import pro.sky.java.course2.employee_book.Exception.EmployeesIsFull;
import pro.sky.java.course2.employee_book.Service.EmployeeService;
import pro.sky.java.course2.employee_book.data.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public String greetings() {
        return "Книга Сотрудников. В данной книге возможно добавлять, удалять и искать сотрудников!";
    }

    @Override
    public String add(String firstName, String lastName, String middleName) {
        Employee employee = new Employee(firstName, lastName, middleName);
        if (employees.contains(employee)) {
            throw new EmployeeExist();
        }
        if (employees.size() == 3) {
            throw new EmployeesIsFull();
        }
        employees.add(employee);
        return "Сотрудник " + employee + " - добавлен";
    }

    @Override
    public String remove(String firstName, String lastName, String middleName) {
        Employee employee = new Employee(firstName, lastName, middleName);
        if (employees.remove(employee)) {
            return "Сотрудник " + employee.getEmployeeFullName() + " - удален";
        }
        throw new EmployeeNotFound();
    }

    @Override
    public String find(String firstName, String lastName, String middleName) {
        Employee employee = new Employee(firstName, lastName, middleName);
        if (employees.contains(employee)) {
            return "Сотрудник " + employee.getEmployeeFullName() + " - найден";
        }
        throw new EmployeeNotFound();
    }

    @Override
    public List<Employee> printAllEmployees() {
        return employees;
    }
}