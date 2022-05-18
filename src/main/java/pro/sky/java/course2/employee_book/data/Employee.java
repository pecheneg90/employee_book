package pro.sky.java.course2.employee_book.data;

import java.util.Objects;

public class Employee {

    String employeeFirstName;
    String employeeLastName;
    String employeeMiddleName;
    double salaryMonth;
    int department;

    public double getSalaryMonth() {
        return salaryMonth;
    }

    public int getDepartment() {
        return department;
    }

    public Employee(String firstName, String lastName, String middleName, int department, double salaryMonth) {
        this.employeeFirstName = firstName;
        this.employeeLastName = lastName;
        this.employeeMiddleName = middleName;
        this.department = department;
        this.salaryMonth = salaryMonth;
    }

    public String getFullName() {
        return employeeFirstName + " "
                + employeeLastName + " "
                + employeeMiddleName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeMiddleName='" + employeeMiddleName + '\'' +
                ", salaryMonth=" + salaryMonth +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salaryMonth, salaryMonth) == 0 && department == employee.department && employeeFirstName.equals(employee.employeeFirstName) && employeeLastName.equals(employee.employeeLastName) && employeeMiddleName.equals(employee.employeeMiddleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeFirstName, employeeLastName, employeeMiddleName, salaryMonth, department);
    }
}