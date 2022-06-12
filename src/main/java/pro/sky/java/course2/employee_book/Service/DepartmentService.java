package pro.sky.java.course2.employee_book.Service;

import pro.sky.java.course2.employee_book.data.Employee;

import java.util.List;

public interface DepartmentService {

    Employee minSalaryMonth(int department);

    Employee maxSalaryMonth(int department);

    List<Employee> departmentAll(Integer department);
}