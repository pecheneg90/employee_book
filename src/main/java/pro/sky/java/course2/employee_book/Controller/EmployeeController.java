package pro.sky.java.course2.employee_book.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employee_book.Service.EmployeeService;
import pro.sky.java.course2.employee_book.Service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @GetMapping
    public String greetings() {
        return employeeService.greetings();
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam String middleName) {
        return employeeService.add(firstName, lastName, middleName);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String middleName) {
        return employeeService.remove(firstName, lastName, middleName);
    }

    @GetMapping("/find")
    public String find(@RequestParam String firstName,
                       @RequestParam String lastName,
                       @RequestParam String middleName) {
        return employeeService.find(firstName, lastName, middleName);
    }
}