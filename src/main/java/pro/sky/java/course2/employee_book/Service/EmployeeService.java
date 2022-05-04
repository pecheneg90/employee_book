package pro.sky.java.course2.employee_book.Service;

public interface EmployeeService {

    String greetings();

    String add(String firstName, String lastName, String middleName);

    String remove(String firstName, String lastName, String middleName);

    String find(String firstName, String lastName, String middleName);
}