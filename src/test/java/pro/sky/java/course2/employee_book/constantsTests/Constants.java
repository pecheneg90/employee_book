package pro.sky.java.course2.employee_book.constantsTests;

import pro.sky.java.course2.employee_book.data.Employee;

import java.util.Collection;
import java.util.List;

public class Constants {
    public static final String FIRSTNAME1 = "Ivan";
    public static final String LASTNAME1 = "Ivanov";
    public static final String MIDDLENAME1 = "Ivanovich";
    public static final int DEPARNMENT1 = 1;
    public static final double SALARYMONTH1 = 21234.20;

    public static final String FIRSTNAME2 = "Petr";
    public static final String LASTNAME2 = "Petrov";
    public static final String MIDDLENAME2 = "Petrovich";
    public static final int DEPARNMENT2 = 2;
    public static final double SALARYMONTH2 = 43234.50;

    public static final String FIRSTNAME3 = "Sidr";
    public static final String LASTNAME3 = "Sidorov";
    public static final String MIDDLENAME3 = "Sidorovich";
    public static final int DEPARNMENT3 = 2;
    public static final double SALARYMONTH3 = 76466.50;

    public static final Employee EMPLOYEE1 = new Employee(
            "Ivan", "Ivanov", "Ivanovich",
            1, 21234.20);
    public static final Employee EMPLOYEE2 = new Employee(
            "Petr", "Petrov", "Petrovich",
            2, 43234.50);
    public static final Employee EMPLOYEE3 = new Employee(
            "Sidr", "Sidorov", "Sidorovich",
            2, 76466.50);


    public static final String WRONGNAME = "32312312";
    public static final String WRONGLASTNAME = "31232";
    public static final String WRONGMIDDLENAME = "32323131";

    public static final String LOWERCASENAME = "petr";
    public static final String LOWERCASELASTNAME = "petrov";
    public static final String LOWERCASEMIDDLENAME = "petrovich";

    public static final Collection<Employee> TESTCOLLECTION = List.of(EMPLOYEE1, EMPLOYEE2);
}