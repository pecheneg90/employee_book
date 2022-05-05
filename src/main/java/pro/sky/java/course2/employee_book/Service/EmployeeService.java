package pro.sky.java.course2.employee_book.Service;

import pro.sky.java.course2.employee_book.data.Employee;

import java.util.Collection;

public interface EmployeeService {

    String greetings();

    Employee add(String firstName, String lastName, String middleName);

    Employee remove(String firstName, String lastName, String middleName);

    Employee find(String firstName, String lastName, String middleName);

    Collection<Employee> printAllEmployees();
}