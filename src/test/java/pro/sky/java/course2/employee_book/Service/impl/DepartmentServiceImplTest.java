package pro.sky.java.course2.employee_book.Service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.employee_book.Exception.EmployeeNotFound;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.employee_book.constantsTests.Constants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    void minSalaryMonth() {
        when(employeeService.printAllEmployees())
                .thenReturn(TESTCOLLECTION);
        assertEquals(EMPLOYEE2, out.minSalaryMonth(2));
    }

    @Test
    void maxSalaryMonth() {
        when(employeeService.printAllEmployees())
                .thenReturn(TESTCOLLECTION);
        assertEquals(EMPLOYEE1, out.maxSalaryMonth(1));
    }

    @Test
    void testThrowsDepNotFound() {
        when(employeeService.printAllEmployees())
                .thenReturn(TESTCOLLECTION);
        assertThrows(EmployeeNotFound.class, (() -> out.maxSalaryMonth(3)));
        assertThrows(EmployeeNotFound.class, (() -> out.minSalaryMonth(3)));
    }

    @Test
    void departmentAll() {
        when(employeeService.printAllEmployees())
                .thenReturn(TESTCOLLECTION);
        assertIterableEquals(TESTCOLLECTION, out.departmentAll(null));
    }
}