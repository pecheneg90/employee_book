package pro.sky.java.course2.employee_book.Service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employee_book.Exception.EmployeeExist;
import pro.sky.java.course2.employee_book.Exception.EmployeeNotFound;
import pro.sky.java.course2.employee_book.Exception.EmployeesIsFull;
import pro.sky.java.course2.employee_book.data.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Employee[] employees = new Employee[3];

    @Override
    public String greetings() {
        return "Книга Сотрудников. В данной книге возможно добавлять, удалять и искать сотрудников!";
    }

    @Override
    public String add(String firstName, String lastName, String middleName) {
        Employee employee = new Employee(firstName, lastName, middleName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName, middleName);
                return "Сотрудник " + employee.getEmployeeFullName() + " - добавлен";
            }
            if (employee.equals(employees[i])) {
                throw new EmployeeExist();
            }
        }
        throw new EmployeesIsFull();
    }

    @Override
    public String remove(String firstName, String lastName, String middleName) {
        Employee employee = new Employee(firstName, lastName, middleName);
        for (int i = 0; i < employees.length; i++) {
            if (employee.equals(employees[i])) {
                employees[i] = null;
                return "Сотрудник " + employee.getEmployeeFullName() + " - удален";
            }
        }
        throw new EmployeeNotFound();
    }

    @Override
    public String find(String firstName, String lastName, String middleName) {
        Employee employee = new Employee(firstName, lastName, middleName);
        for (Employee value : employees) {
            if (employee.equals(value)) {
                return "Сотрудник " + employee.getEmployeeFullName() + " - найден";
            }
        }
        throw new EmployeeNotFound();
    }
}