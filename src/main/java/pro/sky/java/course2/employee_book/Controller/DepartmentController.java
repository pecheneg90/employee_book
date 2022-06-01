package pro.sky.java.course2.employee_book.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employee_book.Service.DepartmentService;
import pro.sky.java.course2.employee_book.data.Employee;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return service.minSalaryMonth(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return service.maxSalaryMonth(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> allEmployeesDepartment(@RequestParam(required = false) Integer departmentId) {
        return service.departmentAll(departmentId);
    }
}