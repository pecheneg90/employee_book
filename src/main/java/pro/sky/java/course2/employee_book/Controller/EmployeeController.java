package pro.sky.java.course2.employee_book.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employee_book.Service.EmployeeService;
import pro.sky.java.course2.employee_book.data.Employee;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String greetings() {
        return service.greetings();
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam String middleName) {
        return service.add(firstName, lastName, middleName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String middleName) {
        return service.remove(firstName, lastName, middleName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String middleName) {
        return service.find(firstName, lastName, middleName);
    }

    @GetMapping("/allList")
    public Collection<Employee> allList() {
        return service.printAllEmployees();
    }
}