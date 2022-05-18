package pro.sky.java.course2.employee_book.Service;

import pro.sky.java.course2.employee_book.data.Employee;

import java.util.Collection;

public interface EmployeeService {

    String greetings();

    Employee add(String firstName, String lastName, String middleName, int department, double salaryMonth);

    Employee remove(String firstName, String lastName, String middleName, int department, double salaryMonth);

    Employee find(String firstName, String lastName, String middleName, int department, double salaryMonth);

    Collection<Employee> printAllEmployees();
}