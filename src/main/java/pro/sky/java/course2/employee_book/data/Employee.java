package pro.sky.java.course2.employee_book.data;

import java.util.Objects;

public class Employee {

    String employeeFirstName;
    String employeeLastName;
    String employeeMiddleName;
    double salaryMonth;
    int department;

    public Employee(String firstName, String lastName, String middleName) {
        this.employeeFirstName = firstName;
        this.employeeLastName = lastName;
        this.employeeMiddleName = middleName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public String getEmployeeMiddleName() {
        return employeeMiddleName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", employeeFirstName='" + getEmployeeFirstName() + '\'' +
                ", employeeLastName='" + getEmployeeLastName() + '\'' +
                ", employeeMiddleName='" + getEmployeeMiddleName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getEmployeeMiddleName().equals(employee.employeeFirstName)
                && employeeLastName.equals(employee.employeeLastName)
                && employeeMiddleName.equals(employee.employeeMiddleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeFirstName, employeeLastName, employeeMiddleName);
    }
}