package pro.sky.java.course2.employee_book.Service.impl;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.employee_book.Exception.EmployeeExist;
import pro.sky.java.course2.employee_book.Exception.EmployeeNotFound;
import pro.sky.java.course2.employee_book.Exception.EmployeesIsFull;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.employee_book.constantsTests.Constants.*;

class EmployeeServiceImplTest {
    EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    void testAddEmployee() {
        assertEquals(EMPLOYEE1, out.add(
                FIRSTNAME1, LASTNAME1, MIDDLENAME1,
                DEPARNMENT1, SALARYMONTH1));
    }

    @Test
    void testCapitalizeEmployeeNames() {
        assertEquals(EMPLOYEE2, out.add(
                LOWERCASENAME, LOWERCASELASTNAME, LOWERCASEMIDDLENAME,
                DEPARNMENT2, SALARYMONTH2));
    }

    @Test
    void testTrowsEmployeeExisNotNumeric() {
        assertThrows(EmployeeExist.class, (() -> out.add(WRONGNAME, WRONGLASTNAME,
                WRONGMIDDLENAME, DEPARNMENT1, SALARYMONTH1)));
    }

    @Test
    void testTrowsEmployeeAlreadyExists() {
        out.add(FIRSTNAME1, LASTNAME1, MIDDLENAME1, DEPARNMENT1, SALARYMONTH1);
        assertThrows(EmployeeExist.class, (() -> out.add(
                FIRSTNAME1, LASTNAME1, MIDDLENAME1, DEPARNMENT1, SALARYMONTH1)));
    }

    @Test
    void testTrowsEmployeeIsFull() {
        out.add(FIRSTNAME1, LASTNAME1, MIDDLENAME1, DEPARNMENT1, SALARYMONTH1);
        out.add(FIRSTNAME2, LASTNAME2, MIDDLENAME2, DEPARNMENT2, SALARYMONTH2);
        assertThrows(EmployeesIsFull.class, (() -> out.add(
                FIRSTNAME3, LASTNAME3, MIDDLENAME3, DEPARNMENT3, SALARYMONTH3)));
    }

    @Test
    void testRemoveEmployee() {
        out.add(FIRSTNAME1, LASTNAME1, MIDDLENAME1, DEPARNMENT1, SALARYMONTH1);
        assertEquals(EMPLOYEE1, out.remove(
                FIRSTNAME1, LASTNAME1, MIDDLENAME1, DEPARNMENT1, SALARYMONTH1));
    }

    @Test
    void testFindEmployee() {
        out.add(FIRSTNAME1, LASTNAME1, MIDDLENAME1, DEPARNMENT1, SALARYMONTH1);
        assertEquals(EMPLOYEE1, out.find(
                FIRSTNAME1, LASTNAME1, MIDDLENAME1, DEPARNMENT1, SALARYMONTH1));
    }

    @Test
    void testThrowEmployeeNotFound() {
        out.add(FIRSTNAME1, LASTNAME1, MIDDLENAME1, DEPARNMENT1, SALARYMONTH1);
        assertThrows(EmployeeNotFound.class, (() -> out.find(FIRSTNAME2, LASTNAME2,
                MIDDLENAME2, DEPARNMENT2, SALARYMONTH2)));
        assertThrows(EmployeeNotFound.class, (() -> out.remove(FIRSTNAME2, LASTNAME2,
                MIDDLENAME2, DEPARNMENT2, SALARYMONTH2)));
    }

    @Test
    void testPrintAllEmployees() {
        out.add(FIRSTNAME1, LASTNAME1, MIDDLENAME1, DEPARNMENT1, SALARYMONTH1);
        out.add(FIRSTNAME2, LASTNAME2, MIDDLENAME2, DEPARNMENT2, SALARYMONTH2);
        assertIterableEquals(TESTCOLLECTION, out.printAllEmployees());
    }
}