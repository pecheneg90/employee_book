package pro.sky.java.course2.employee_book.Service;

import pro.sky.java.course2.employee_book.data.Employee;

import java.util.List;

public interface EmployeeService {

    String greetings();

    String add(String firstName, String lastName, String middleName);

    String remove(String firstName, String lastName, String middleName);

    String find(String firstName, String lastName, String middleName);

    List<Employee> printAllEmployees();
}